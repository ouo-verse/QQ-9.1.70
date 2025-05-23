package rk1;

import android.content.Intent;
import android.text.TextUtils;
import androidx.core.util.Consumer;
import com.google.gson.Gson;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.event.GuildAtDialogDismissEvent;
import com.tencent.mobileqq.guild.event.GuildHashtagDialogDismissEvent;
import com.tencent.mobileqq.guild.event.GuildHashtagEvent;
import com.tencent.mobileqq.guild.event.partevent.GuildPartPanelDismissEvent;
import com.tencent.mobileqq.guild.event.partevent.GuildPartSelectEvent;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi;
import com.tencent.mobileqq.guild.feed.event.GuildFeedEmojiEvent;
import com.tencent.mobileqq.guild.feed.jsbridge.methods.publish.helper.GuildUploadHelper;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedPublishEditDraftInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedPublishInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedPublishSwitchInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedPublishThirdContentInitBean;
import com.tencent.mobileqq.guild.feed.publish.event.GuildCallPostFeedTaskFacadeMethodEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildCreateTaskOperationEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildCreateTextLinkEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildDraftH5AutoRestoreEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildDraftTaskResponseEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildFeedThirdContentMediaEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildFeedThirdVideoLinkEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildFontStyleEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildGetDraftTaskOperationEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildPublishViewDestroyEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildRedoEvent;
import com.tencent.mobileqq.guild.feed.publish.result.CreateTextLinkResult;
import com.tencent.mobileqq.guild.feed.publish.result.DraftResult;
import com.tencent.mobileqq.guild.feed.publish.result.EmojiResult;
import com.tencent.mobileqq.guild.feed.publish.result.GuildResult;
import com.tencent.mobileqq.guild.feed.publish.result.RedoResult;
import com.tencent.mobileqq.guild.feed.publish.result.ResultWrapper;
import com.tencent.mobileqq.guild.feed.publish.result.SelectGuildResult;
import com.tencent.mobileqq.guild.feed.publish.result.SwitchResult;
import com.tencent.mobileqq.guild.feed.publish.result.ThirdContentResult;
import com.tencent.mobileqq.guild.feed.publish.result.ThirdVideoLinkResult;
import com.tencent.mobileqq.guild.feed.util.ak;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.bl;
import com.tencent.mobileqq.guild.util.HashTagViewType;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes13.dex */
public class n extends a {

    /* renamed from: i, reason: collision with root package name */
    private GuildFeedPublishInitBean f431637i;

    private void A(GuildCreateTextLinkEvent guildCreateTextLinkEvent) {
        i(new CreateTextLinkResult(guildCreateTextLinkEvent.url, guildCreateTextLinkEvent.desc).c());
    }

    private void B(GuildFeedThirdVideoLinkEvent guildFeedThirdVideoLinkEvent) {
        Gson gson = new Gson();
        i(gson.toJson(new ResultWrapper(14, gson.toJson(new ThirdVideoLinkResult(guildFeedThirdVideoLinkEvent.getUrl(), guildFeedThirdVideoLinkEvent.getType())))));
    }

    private void C() {
        String str;
        if (this.f431637i.isThirdContentPublish()) {
            GuildUploadHelper.i().f();
            return;
        }
        boolean isEditDraft = this.f431637i.isEditDraft();
        boolean isEditPublish = this.f431637i.isEditPublish();
        boolean isSwitchFromNative = this.f431637i.isSwitchFromNative();
        GuildFeedPublishEditDraftInitBean draftBean = this.f431637i.getDraftBean();
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(isEditDraft);
            objArr[1] = Boolean.valueOf(isEditPublish);
            objArr[2] = Boolean.valueOf(isSwitchFromNative);
            if (draftBean != null) {
                str = draftBean.getTaskId();
            } else {
                str = null;
            }
            objArr[3] = str;
            QLog.d("Guild_Feed_BaseGuildJsBridgeMethod", 2, String.format("[handleDraft]: isEditDraft=%b, isEditPublish=%b, isSwitch=%b, draftBean.taskId=%s", objArr));
        }
        if (isEditDraft && draftBean != null) {
            GuildUploadHelper.i().s(draftBean.getTaskId());
            i(new DraftResult(draftBean.getFeedJson()).c());
        } else if (isSwitchFromNative) {
            GuildUploadHelper.i().f();
            String feedJson = ((GuildFeedPublishSwitchInitBean) this.f431637i).getFeedJson();
            if (!TextUtils.isEmpty(feedJson)) {
                i(new SwitchResult(feedJson).c());
            }
        } else {
            GuildUploadHelper.i().f();
        }
        if (!isEditDraft && !isEditPublish && !isSwitchFromNative) {
            y();
        } else {
            i(new DraftResult(null).c());
        }
    }

    private void D(final GuildDraftTaskResponseEvent guildDraftTaskResponseEvent) {
        if (!guildDraftTaskResponseEvent.getIsRestore()) {
            ThreadManagerV2.excute(new Runnable() { // from class: rk1.i
                @Override // java.lang.Runnable
                public final void run() {
                    n.this.M(guildDraftTaskResponseEvent);
                }
            }, 64, null, false);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: rk1.j
                @Override // java.lang.Runnable
                public final void run() {
                    n.this.N(guildDraftTaskResponseEvent);
                }
            });
        }
    }

    private void E(GuildFeedEmojiEvent guildFeedEmojiEvent) {
        if (guildFeedEmojiEvent == null) {
            return;
        }
        i(new EmojiResult(guildFeedEmojiEvent.mEmojiType, guildFeedEmojiEvent.getEmojiId(), null).c());
    }

    private void F(GuildDraftH5AutoRestoreEvent guildDraftH5AutoRestoreEvent) {
        i(new DraftResult(guildDraftH5AutoRestoreEvent.getFeedJson()).c());
    }

    private void G(GuildFontStyleEvent guildFontStyleEvent) {
        i(new com.tencent.mobileqq.guild.feed.publish.result.a(guildFontStyleEvent.getGuildSetFontStyleInfo()).c());
    }

    private void H(GuildHashtagEvent guildHashtagEvent) {
        boolean z16;
        String str = guildHashtagEvent.guildId;
        String str2 = guildHashtagEvent.channelUin;
        String str3 = guildHashtagEvent.channelName;
        if (guildHashtagEvent.viewType == HashTagViewType.VIEW_TYPE_FEED_SQUARE) {
            z16 = true;
        } else {
            z16 = false;
        }
        i(new SelectGuildResult(str, str2, str3, z16).c());
    }

    private void I(final GuildPartSelectEvent guildPartSelectEvent) {
        i(new GuildResult(this.f431637i.getTinyId(), this.f431637i.getNickName(), this.f431637i.getGuildId(), guildPartSelectEvent.channelUin).c());
        ax.J(l(), new Consumer() { // from class: rk1.k
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                n.O(GuildPartSelectEvent.this, (in1.e) obj);
            }
        });
    }

    private void J(GuildRedoEvent guildRedoEvent) {
        i(new RedoResult(guildRedoEvent.isRedo()).c());
        ak.m(guildRedoEvent.isRedo());
    }

    private void K(GuildPublishViewDestroyEvent guildPublishViewDestroyEvent) {
        com.tencent.mobileqq.guild.feed.jsbridge.methods.publish.helper.a.b().e();
        GuildUploadHelper.i().q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(GuildDraftTaskResponseEvent guildDraftTaskResponseEvent) {
        if (!this.f431626h) {
            N(guildDraftTaskResponseEvent);
        } else {
            QLog.d("Guild_Feed_BaseGuildJsBridgeMethod", 1, "[handleDraftTaskResponseEvent]: restore feed too long and page has gone");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(GuildDraftTaskResponseEvent guildDraftTaskResponseEvent) {
        final GuildDraftTaskResponseEvent guildDraftTaskResponseEvent2 = (GuildDraftTaskResponseEvent) guildDraftTaskResponseEvent.restoreFromFile();
        if (guildDraftTaskResponseEvent2 == null) {
            QLog.e("Guild_Feed_BaseGuildJsBridgeMethod", 1, "[handleDraftTaskResponseEvent]: finalEvent is null");
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: rk1.m
                @Override // java.lang.Runnable
                public final void run() {
                    n.this.L(guildDraftTaskResponseEvent2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void O(GuildPartSelectEvent guildPartSelectEvent, in1.e eVar) {
        int i3;
        String str = guildPartSelectEvent.channelUin;
        if (guildPartSelectEvent.isSquare) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        eVar.Mb(new bn1.c(str, i3, guildPartSelectEvent.channelName, Boolean.TRUE));
    }

    private void P() {
        C();
        x();
        Q();
        v();
        ak.e(this.f431637i);
    }

    private void Q() {
        GuildFeedPublishInitBean guildFeedPublishInitBean = this.f431637i;
        if (guildFeedPublishInitBean instanceof GuildFeedPublishThirdContentInitBean) {
            String jsonFeedContent = ((GuildFeedPublishThirdContentInitBean) guildFeedPublishInitBean).getJsonFeedContent();
            if (TextUtils.isEmpty(jsonFeedContent)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(jsonFeedContent);
                if (jSONObject.optJSONObject(QCircleFolderFunnelCollect.EXTRA_FEED_TYPE) == null) {
                    jSONObject.put(QCircleFolderFunnelCollect.EXTRA_FEED_TYPE, 1);
                }
                if (jSONObject.optJSONObject(QAdVrReport.ElementID.AD_POSTER) == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("id", this.f431637i.getTinyId());
                    jSONObject2.put("nick", this.f431637i.getNickName());
                    jSONObject.put(QAdVrReport.ElementID.AD_POSTER, jSONObject2);
                }
                if (jSONObject.optJSONObject("channelInfo") == null) {
                    JSONObject jSONObject3 = new JSONObject();
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("guild_id", this.f431637i.getGuildId());
                    jSONObject4.put("channel_id", this.f431637i.getChannelId());
                    jSONObject3.put("sign", jSONObject4);
                    jSONObject.put("channelInfo", jSONObject3);
                }
                if (jSONObject.optJSONArray("images") == null) {
                    jSONObject.put("images", new JSONArray());
                }
                if (jSONObject.optJSONArray("videos") == null) {
                    jSONObject.put("videos", new JSONArray());
                }
                List<LocalMediaInfo> mediaInfoList = ((GuildFeedPublishThirdContentInitBean) this.f431637i).getMediaInfoList();
                if (!mediaInfoList.isEmpty()) {
                    bl.c().a(new GuildFeedThirdContentMediaEvent(jSONObject.toString(), mediaInfoList));
                } else {
                    i(new ThirdContentResult(jSONObject, new ArrayList()).c());
                }
            } catch (Exception e16) {
                QLog.e("Guild_Feed_BaseGuildJsBridgeMethod", 1, "tag: " + k() + " ,[preUpload]-> json parser e\uff1a", e16.getMessage());
            }
        }
    }

    private void R() {
        Intent intent = new Intent();
        GuildFeedBaseInitBean guildFeedBaseInitBean = new GuildFeedBaseInitBean();
        GuildFeedPublishInitBean guildFeedPublishInitBean = this.f431637i;
        if (guildFeedPublishInitBean == null) {
            return;
        }
        guildFeedBaseInitBean.setGuildId(guildFeedPublishInitBean.getGuildId());
        guildFeedBaseInitBean.setChannelId(guildFeedPublishInitBean.getChannelId());
        intent.putExtra(com.tencent.mobileqq.guild.feed.b.f218115a, guildFeedBaseInitBean);
        intent.putExtra("launch_edit_flag", guildFeedPublishInitBean.isEditPublish());
        intent.putExtra("launch_main_task_id", GuildUploadHelper.i().h());
        ((IGuildFeedMiscApi) QRoute.api(IGuildFeedMiscApi.class)).syncCallGetSimpleDataMethod("sync_report_stage_init", intent);
    }

    private void S() {
        try {
            R();
        } catch (Exception e16) {
            QLog.e("Guild_Feed_BaseGuildJsBridgeMethod", 1, "[tryReportStageInit]: ", e16);
        }
    }

    private void v() {
        i(new GuildResult(this.f431637i.getTinyId(), this.f431637i.getNickName(), this.f431637i.getGuildId(), this.f431637i.getChannelId()).c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void N(GuildDraftTaskResponseEvent guildDraftTaskResponseEvent) {
        String guildId = this.f431637i.getGuildId();
        String channelId = this.f431637i.getChannelId();
        if (TextUtils.equals(guildDraftTaskResponseEvent.getRequestEvent().getGuildId(), guildId) && TextUtils.equals(guildDraftTaskResponseEvent.getRequestEvent().getChannelId(), channelId)) {
            if (!TextUtils.isEmpty(guildDraftTaskResponseEvent.getMainTaskId()) && !TextUtils.isEmpty(guildDraftTaskResponseEvent.getFeedJson())) {
                in1.e l3 = l();
                if (l3 == null) {
                    return;
                }
                l3.rd(guildDraftTaskResponseEvent);
                ak.i();
                return;
            }
            i(new DraftResult(null).c());
        }
    }

    private void y() {
        GuildGetDraftTaskOperationEvent guildGetDraftTaskOperationEvent = new GuildGetDraftTaskOperationEvent();
        guildGetDraftTaskOperationEvent.setGuildId(this.f431637i.getGuildId());
        guildGetDraftTaskOperationEvent.setChannelId(this.f431637i.getChannelId());
        guildGetDraftTaskOperationEvent.setPublisherType("GuildMain");
        guildGetDraftTaskOperationEvent.setIpcEvent(true);
        guildGetDraftTaskOperationEvent.setRequestId(String.valueOf(guildGetDraftTaskOperationEvent.hashCode()));
        bl.c().b(guildGetDraftTaskOperationEvent, true);
    }

    private void z() {
        final in1.e l3 = l();
        if (l3 == null) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: rk1.l
            @Override // java.lang.Runnable
            public final void run() {
                in1.e.this.showKeyboard();
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    public String k() {
        return DownloadInfo.spKey_Config;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // rk1.a, ok1.a
    public void m() {
        super.m();
        com.tencent.mobileqq.guild.feed.jsbridge.methods.publish.helper.a.b().d(this);
        GuildUploadHelper.i().o(this);
    }

    @Override // ok1.a
    protected boolean o(String str, String str2, String str3) {
        in1.e l3 = l();
        if (l3 == null) {
            return false;
        }
        GuildFeedPublishInitBean initBean = l3.getInitBean();
        this.f431637i = initBean;
        if (initBean == null) {
            return false;
        }
        l3.Z6();
        P();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // rk1.a, ok1.a
    public void onDestroy() {
        super.onDestroy();
        GuildCallPostFeedTaskFacadeMethodEvent guildCallPostFeedTaskFacadeMethodEvent = new GuildCallPostFeedTaskFacadeMethodEvent(GuildUploadHelper.i().h());
        guildCallPostFeedTaskFacadeMethodEvent.wrapCall(2, 1, 0);
        bl.c().b(guildCallPostFeedTaskFacadeMethodEvent, false);
    }

    @Override // rk1.a
    public ArrayList<Class> p() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildCreateTextLinkEvent.class);
        arrayList.add(GuildFeedEmojiEvent.class);
        arrayList.add(GuildHashtagEvent.class);
        arrayList.add(GuildPartSelectEvent.class);
        arrayList.add(GuildDraftTaskResponseEvent.class);
        arrayList.add(GuildDraftH5AutoRestoreEvent.class);
        arrayList.add(GuildRedoEvent.class);
        arrayList.add(GuildFontStyleEvent.class);
        arrayList.add(GuildAtDialogDismissEvent.class);
        arrayList.add(GuildHashtagDialogDismissEvent.class);
        arrayList.add(GuildPartPanelDismissEvent.class);
        arrayList.add(GuildFeedThirdVideoLinkEvent.class);
        return arrayList;
    }

    @Override // rk1.a
    public void q(SimpleBaseEvent simpleBaseEvent) {
        if (this.f431637i == null) {
            return;
        }
        if (simpleBaseEvent instanceof GuildCreateTextLinkEvent) {
            A((GuildCreateTextLinkEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildDraftTaskResponseEvent) {
            D((GuildDraftTaskResponseEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildFeedEmojiEvent) {
            E((GuildFeedEmojiEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildHashtagEvent) {
            H((GuildHashtagEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildPartSelectEvent) {
            I((GuildPartSelectEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildPublishViewDestroyEvent) {
            K((GuildPublishViewDestroyEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildDraftH5AutoRestoreEvent) {
            F((GuildDraftH5AutoRestoreEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildRedoEvent) {
            J((GuildRedoEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildFontStyleEvent) {
            G((GuildFontStyleEvent) simpleBaseEvent);
            return;
        }
        if (!(simpleBaseEvent instanceof GuildAtDialogDismissEvent) && !(simpleBaseEvent instanceof GuildHashtagDialogDismissEvent) && !(simpleBaseEvent instanceof GuildPartPanelDismissEvent)) {
            if (simpleBaseEvent instanceof GuildFeedThirdVideoLinkEvent) {
                B((GuildFeedThirdVideoLinkEvent) simpleBaseEvent);
                return;
            }
            return;
        }
        z();
    }

    public void x() {
        boolean z16;
        String h16 = GuildUploadHelper.i().h();
        String guildId = this.f431637i.getGuildId();
        String channelId = this.f431637i.getChannelId();
        boolean isEditPublish = this.f431637i.isEditPublish();
        GuildFeedPublishInitBean guildFeedPublishInitBean = this.f431637i;
        if ((guildFeedPublishInitBean instanceof GuildFeedPublishSwitchInitBean) && ((GuildFeedPublishSwitchInitBean) guildFeedPublishInitBean).isEditNativePublish().booleanValue()) {
            z16 = true;
        } else {
            z16 = isEditPublish;
        }
        S();
        GuildCreateTaskOperationEvent guildCreateTaskOperationEvent = new GuildCreateTaskOperationEvent(h16, guildId, channelId, z16, this.f431637i.getBusinessType(), com.tencent.mobileqq.guild.feed.nativepublish.utils.k.c(2, this.f431637i), 0);
        guildCreateTaskOperationEvent.setEnablePreUpload(Boolean.TRUE);
        guildCreateTaskOperationEvent.setPreUploadGuardByNetworkCondition(false);
        bl.c().b(guildCreateTaskOperationEvent, true);
        GuildCallPostFeedTaskFacadeMethodEvent guildCallPostFeedTaskFacadeMethodEvent = new GuildCallPostFeedTaskFacadeMethodEvent(h16);
        guildCallPostFeedTaskFacadeMethodEvent.wrapCall(1, 1);
        bl.c().b(guildCallPostFeedTaskFacadeMethodEvent, true);
    }
}
