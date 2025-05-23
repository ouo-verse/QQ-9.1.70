package z93;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J(\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH&J\b\u0010\u0010\u001a\u00020\u0007H&\u00a8\u0006\u0011"}, d2 = {"Lz93/a;", "", "Landroid/content/Intent;", "intent", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel;", "winkEditorViewModel", "", "", "a", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "alreadySelectedMediaCount", "requestCode", "", "b", "getCameraMaterialUnZipDownload", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface a {
    @Nullable
    Map<String, String> a(@Nullable Intent intent, @NotNull WinkEditorViewModel winkEditorViewModel);

    boolean b(@NotNull Activity activity, @NotNull Intent intent, int alreadySelectedMediaCount, int requestCode);

    @NotNull
    String getCameraMaterialUnZipDownload();
}
