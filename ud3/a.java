package ud3;

import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zplan.dresskey.api.DressInfoIPCData;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.zplan.world.model.FirstFrameResult;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H&J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH&J \u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H&J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H&\u00a8\u0006\u0018"}, d2 = {"Lud3/a;", "", "", "modConfigJson", "", "p", "", "errorCode", "errorMessage", "A1", "Lcom/tencent/mobileqq/zplan/dresskey/api/DressInfoIPCData;", "maleAvatarCharacter", "femaleAvatarCharacter", ICustomDataEditor.STRING_ARRAY_PARAM_2, "", "success", "Lorg/json/JSONObject;", "params", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "enterParams", "j2", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "result", "W0", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public interface a {
    void A1(int errorCode, String errorMessage);

    void W0(FirstFrameResult result);

    void a2(DressInfoIPCData maleAvatarCharacter, DressInfoIPCData femaleAvatarCharacter);

    void j2(boolean success, JSONObject params, ZootopiaEnterParams enterParams);

    void p(String modConfigJson);
}
