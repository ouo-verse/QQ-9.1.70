package ze2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ecommerce.base.photobrowser.api.IECPhotoBrowser;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJF\u0010\u000b\u001a\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052&\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lze2/a;", "Lcom/tencent/ecommerce/base/photobrowser/api/IECPhotoBrowser;", "", "", "photoUrl", "", "index", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "", "show", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a implements IECPhotoBrowser {
    @Override // com.tencent.ecommerce.base.photobrowser.api.IECPhotoBrowser
    public void show(List<String> photoUrl, int index, HashMap<String, String> params) {
        Intrinsics.checkNotNullParameter(photoUrl, "photoUrl");
        Context application = BaseApplicationImpl.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication()");
        if (Foreground.getTopActivity() != null) {
            application = Foreground.getTopActivity();
            Intrinsics.checkNotNullExpressionValue(application, "getTopActivity()");
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(photoUrl);
        Intent intent = new Intent(application, (Class<?>) TroopAvatarWallPreviewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        bundle.putStringArrayList(TroopAvatarWallPreviewActivity.KEY_SEQ_NUM, arrayList);
        bundle.putBoolean("needBottomBar", false);
        bundle.putBoolean("IS_EDIT", false);
        bundle.putBoolean("is_use_path", true);
        bundle.putBoolean("is_show_action", true);
        bundle.putBoolean(TroopAvatarWallPreviewActivity.KEY_IS_NOT_SHOW_INDEX, false);
        bundle.putBoolean("is_index_show_bottom", true);
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                bundle.putString(entry.getKey(), entry.getValue());
            }
            bundle.putSerializable(TroopAvatarWallPreviewActivity.KEY_DT_PG_PARAMS, params);
        }
        intent.putExtras(bundle);
        application.startActivity(intent);
    }
}
