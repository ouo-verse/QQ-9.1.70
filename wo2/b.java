package wo2;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.qqcircle.immersive.views.search.util.ad;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {
    public static CharSequence a(TextView textView, int i3, CharSequence charSequence, List<String> list) {
        int i16;
        if (list != null && !list.isEmpty()) {
            int maxLines = textView.getMaxLines();
            if (maxLines < 1) {
                i16 = 1;
            } else {
                i16 = maxLines;
            }
            return SearchUtils.I(textView, i3, i16, charSequence, list, false, false);
        }
        return charSequence;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <VM extends BaseViewModel> VM b(Context context, Class<VM> cls) {
        if ((context instanceof Activity) && (context instanceof ViewModelStoreOwner)) {
            return (VM) new ViewModelProvider((ViewModelStoreOwner) context, ViewModelProvider.AndroidViewModelFactory.getInstance(((Activity) context).getApplication())).get(cls.getName(), cls);
        }
        return null;
    }

    public static void c(URLImageView uRLImageView, String str) {
        ad.s(uRLImageView, str);
    }
}
