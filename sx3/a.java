package sx3;

import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0000H\u0002\u001a\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0000\u00a8\u0006\u0007"}, d2 = {"Lrx3/b;", "Landroid/os/Bundle;", "b", "", "c", "Lorg/json/JSONObject;", "a", "qwallet-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {
    @NotNull
    public static final JSONObject a(@NotNull rx3.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("listid", bVar.getBillNo());
        jSONObject.put("senderuin", bVar.d());
        jSONObject.put("name", com.tencent.mobileqq.base.a.b());
        jSONObject.put("grouptype", String.valueOf(bVar.getGroupType()));
        jSONObject.put(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, bVar.getGroupId());
        jSONObject.put(WadlProxyConsts.CHANNEL, bVar.getRedChannel());
        jSONObject.put("resource_type", bVar.getElemResv().uint32_resource_type.get());
        jSONObject.put("skin_id", bVar.getElemResv().uint32_skin_id.get());
        jSONObject.put("outer_skin_id", bVar.getElemResv().bytes_outer_skin_id.get().toStringUtf8());
        jSONObject.put("skin_from", bVar.getElemResv().uint32_skin_from.get());
        jSONObject.put("hb_from", bVar.getElemResv().uint32_hb_from.get());
        jSONObject.put("fromHBList", 0);
        jSONObject.put("groupuin", bVar.d());
        jSONObject.put("authkey", bVar.getAuthkey());
        jSONObject.put("curFriendUin", bVar.getPeerUinStr());
        jSONObject.put("pay_flag", bVar.getBodyResv().uint32_pay_flag.get());
        jSONObject.put("hb_flag", bVar.getBodyResv().uint32_hb_flag.get());
        return jSONObject;
    }

    @NotNull
    public static final Bundle b(@NotNull rx3.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        String c16 = c(bVar);
        Bundle bundle = new Bundle();
        bundle.putInt("voice_group_type", bVar.getGroupType());
        bundle.putString("voice_list_id", bVar.getBillNo());
        bundle.putString("voice_sender_uin", bVar.d());
        bundle.putString("voice_peer_uin", bVar.getPeerUinStr());
        bundle.putString("voice_group_id", bVar.getGroupId());
        bundle.putString("voice_auth_key", bVar.getAuthkey());
        bundle.putBoolean("voice_is_self_send", bVar.getIsSelf());
        bundle.putString("voice_command", bVar.getTitle());
        bundle.putInt("voice_record_duration_millis", bVar.getElemResv().sound_record_duration.get() * 1000);
        bundle.putString("voice_to_detail_json", c16);
        return bundle;
    }

    private static final String c(rx3.b bVar) {
        String jSONObject = a(bVar).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "createBasicExtraData().toString()");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("userId", com.tencent.mobileqq.base.a.c());
        jSONObject2.put(HippyHeaderListViewController.VIEW_TAG, "redgiftDetail");
        jSONObject2.put(j.T0, "appid#1344242394|bargainor_id#1000030201|channel#detailtips");
        jSONObject2.put(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM, 2);
        jSONObject2.put("extra_data", jSONObject);
        jSONObject2.put("senderuin", bVar.getSenderUin());
        String jSONObject3 = jSONObject2.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "toDetailObj.toString()");
        return jSONObject3;
    }
}
