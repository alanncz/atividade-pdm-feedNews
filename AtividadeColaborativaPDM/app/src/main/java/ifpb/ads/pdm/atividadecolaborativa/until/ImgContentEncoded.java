package ifpb.ads.pdm.atividadecolaborativa.until;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImgContentEncoded {

    public static String getImg(String contentEncoded) {

        Pattern PATTERN_IMG = Pattern.compile("<img .*\\/>");
        Pattern PATTERN_SRC = Pattern.compile("http.+\\.[a-z]*\"");

        Matcher matcher = PATTERN_IMG.matcher(contentEncoded);
        if(matcher.find()){
            String img = matcher.group(0);
            Matcher matcheSrc = PATTERN_SRC.matcher(img);
            if(matcheSrc.find()){
                String src = matcheSrc.group(0);
                src = src.substring(0,src.length()-1);
                return src;
            }
        }
        return null;
    }
}
