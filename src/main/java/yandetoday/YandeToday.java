package yandetoday;

import com.alibaba.fastjson.JSON;
import marker.builder.MarkdownBuilder;
import yandetoday.common.Const;
import yandetoday.common.Tools;
import yandetoday.entity.Post;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class YandeToday {

    private List<Post> posts;

    private YandeToday() {

    }

    public static YandeToday newDay() {
        YandeToday yandeToday = new YandeToday();
        try {
            URL url = new URL(Const.YANDE_POPUlAR_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(3000);
            connection.connect();
            int code = connection.getResponseCode();
            if (code == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                reader.close();
                List<Post> posts = JSON.parseArray(sb.toString(), Post.class);
                yandeToday.posts = posts;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return yandeToday;
    }

    public String getMarkdown() {
        MarkdownBuilder markdownBuilder = new MarkdownBuilder();
        markdownBuilder.addHeader("Yande Today - " + Tools.now());
        for (Post post : this.posts) {
            if (Const.TYPE_SAFE.equalsIgnoreCase(post.getRating())) {
                markdownBuilder.addText(post.getMarkdown());
            }
        }

        return markdownBuilder.toString();
    }

    public void saveMarkdown(String path) {

        File file = new File(path + "YandeToady_" + Tools.nowForFile() + ".md");
        if (file.exists()) {
            return;
        }
        //判断目标文件所在的目录是否存在
        if (file.getParentFile() != null &&!file.getParentFile().exists()) {
            //如果目标文件所在的目录不存在，则创建父目录
            System.out.println("目标文件所在目录不存在，准备创建它！");
            if (!file.getParentFile().mkdirs()) {
                System.out.println("创建目标文件所在目录失败！");
                return;
            }
        }
        //创建目标文件
        try {
            if (file.createNewFile()) {
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(getMarkdown());
                bw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;

        }
    }

    public void saveMarkdown() {
        saveMarkdown("");
    }

}
