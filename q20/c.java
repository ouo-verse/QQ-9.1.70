package q20;

import androidx.annotation.NonNull;
import com.tencent.richframework.text.rich.parser.RichTextAtParser;
import java.util.List;
import java.util.regex.Matcher;
import qqcircle.QQCircleEnvHub$CommentActivityInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c implements a {
    @Override // q20.a
    public int a() {
        return 2;
    }

    @Override // q20.a
    public boolean b(@NonNull QQCircleEnvHub$CommentActivityInfo qQCircleEnvHub$CommentActivityInfo, String str, boolean z16, List<String> list) {
        if (!d.d(qQCircleEnvHub$CommentActivityInfo, list)) {
            return false;
        }
        Matcher matcher = RichTextAtParser.AT_PATTERN.matcher(str);
        int i3 = qQCircleEnvHub$CommentActivityInfo.atCondition.minUserInvolve.get();
        if (i3 <= 0) {
            i3 = 1;
        }
        int i16 = qQCircleEnvHub$CommentActivityInfo.atCondition.maxUserInvolve.get();
        if (i16 < i3) {
            i16 = Integer.MAX_VALUE;
        }
        int i17 = 0;
        while (matcher.find()) {
            i17++;
        }
        if (i17 < i3 || i17 > i16) {
            return false;
        }
        return true;
    }
}
