package rk1;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.util.Consumer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.data.GuildSimpleContact;
import com.tencent.mobileqq.guild.feed.event.FeedEditorEvent;
import com.tencent.mobileqq.guild.feed.jsbridge.methods.publish.helper.GuildUploadHelper;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedPublishInitBean;
import com.tencent.mobileqq.guild.feed.publish.event.GuildTriggerPublishOperationEvent;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.bl;
import com.tencent.mobileqq.guild.ipc.methods.aj;
import com.tencent.mobileqq.guild.ipc.methods.aq;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes13.dex */
public class v extends b {
    private void A() {
        HashMap<String, Serializable> attrs = l().getInitBean().getAttrs();
        com.tencent.mobileqq.guild.util.y.g(aq.class, (Long) attrs.get("topic_id"), (String) attrs.get("topic_name"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void B(AtomicInteger atomicInteger, HashMap hashMap) {
        Integer num = (Integer) hashMap.get("launch_redirect_action");
        if (num != null) {
            atomicInteger.set(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void C(final AtomicInteger atomicInteger, GuildFeedPublishInitBean guildFeedPublishInitBean) {
        ax.J(guildFeedPublishInitBean.getAttrs(), new Consumer() { // from class: rk1.t
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                v.B(atomicInteger, (HashMap) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void D(final AtomicInteger atomicInteger, in1.e eVar) {
        ax.J(eVar.getInitBean(), new Consumer() { // from class: rk1.q
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                v.C(atomicInteger, (GuildFeedPublishInitBean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void E(AtomicInteger atomicInteger, HashMap hashMap) {
        Integer num = (Integer) hashMap.get("launch_request_id");
        if (num != null) {
            atomicInteger.set(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void F(final AtomicInteger atomicInteger, GuildFeedPublishInitBean guildFeedPublishInitBean) {
        ax.J(guildFeedPublishInitBean.getAttrs(), new Consumer() { // from class: rk1.u
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                v.E(atomicInteger, (HashMap) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void G(final AtomicInteger atomicInteger, in1.e eVar) {
        ax.J(eVar.getInitBean(), new Consumer() { // from class: rk1.s
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                v.F(atomicInteger, (GuildFeedPublishInitBean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(in1.e eVar, Boolean bool) {
        if (bool.booleanValue()) {
            I(eVar);
        }
    }

    private boolean I(in1.e eVar) {
        int i3;
        String guildId = eVar.getInitBean().getGuildId();
        String channelId = eVar.getInitBean().getChannelId();
        if (!Boolean.valueOf(eVar.getInitBean().isEditPublish()).booleanValue() && !((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isChannelExist(channelId)) {
            if (((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isChannelGray(guildId)) {
                i3 = R.string.f144900q1;
            } else {
                i3 = R.string.f144880pz;
            }
            com.tencent.mobileqq.guild.util.qqui.g.c(1, i3);
            return false;
        }
        a("contentLinks");
        ArrayList arrayList = new ArrayList();
        arrayList.add(g("title"));
        arrayList.add(g("contentText"));
        try {
            if (ax.g(guildId, new JSONObject(j()))) {
                return false;
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        if (eVar.P3()) {
            eVar.ac(j(), true);
        } else {
            int x16 = x();
            if (x16 == 1) {
                z(eVar.getInitBean());
            } else if (x16 == 2) {
                A();
            }
            w(eVar.getInitBean().getBusinessType());
            eVar.finish();
        }
        return true;
    }

    private void w(int i3) {
        boolean z16;
        GuildTriggerPublishOperationEvent guildTriggerPublishOperationEvent = new GuildTriggerPublishOperationEvent();
        guildTriggerPublishOperationEvent.setMainTaskId(GuildUploadHelper.i().h());
        guildTriggerPublishOperationEvent.setJson(j());
        if (i3 == 7) {
            z16 = true;
        } else {
            z16 = false;
        }
        guildTriggerPublishOperationEvent.showSuccessToast = z16;
        guildTriggerPublishOperationEvent.setBusinessType(i3);
        in1.e l3 = l();
        if (l3 != null) {
            guildTriggerPublishOperationEvent.setIsEdit(l3.getInitBean().isEditPublish());
            guildTriggerPublishOperationEvent.setNewFeed(!l3.getInitBean().isEditPublish());
            bl.c().b(guildTriggerPublishOperationEvent, true);
            bl.c().b(new FeedEditorEvent.OnStartPublishFeedEvent(y(), guildTriggerPublishOperationEvent.getMainTaskId(), l3.getInitBean().isEditPublish(), new GuildSimpleContact(l3.getInitBean().getGuildId(), l3.getInitBean().getChannelId()), false), true);
        }
    }

    private int x() {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        ax.J(l(), new Consumer() { // from class: rk1.p
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                v.D(atomicInteger, (in1.e) obj);
            }
        });
        return atomicInteger.get();
    }

    private int y() {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        ax.J(l(), new Consumer() { // from class: rk1.r
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                v.G(atomicInteger, (in1.e) obj);
            }
        });
        return atomicInteger.get();
    }

    private void z(@Nullable GuildFeedBaseInitBean guildFeedBaseInitBean) {
        HashMap<String, Serializable> hashMap;
        JumpGuildParam.JoinInfoParam joinInfoParam = null;
        if (guildFeedBaseInitBean != null) {
            hashMap = guildFeedBaseInitBean.getAttrs();
        } else {
            hashMap = null;
        }
        if (hashMap == null) {
            QLog.e("Guild_Feed_BaseGuildJsBridgeMethod", 1, "[jumpGuildMainPage]: attrs is null");
            return;
        }
        String guildId = guildFeedBaseInitBean.getGuildId();
        if (TextUtils.isEmpty(guildId)) {
            QLog.e("Guild_Feed_BaseGuildJsBridgeMethod", 1, "[jumpGuildMainPage]: guildId is empty");
            return;
        }
        Serializable serializable = hashMap.get(JumpGuildParam.KEY_JOIN_INFO_PARAM);
        if (serializable instanceof JumpGuildParam.JoinInfoParam) {
            joinInfoParam = (JumpGuildParam.JoinInfoParam) serializable;
        }
        com.tencent.mobileqq.guild.util.y.g(aj.class, 0, new JumpGuildParam(guildId, "", joinInfoParam));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    public String k() {
        return "publish";
    }

    @Override // ok1.a
    protected boolean o(String str, String str2, String str3) {
        final in1.e l3 = l();
        if (l3 == null) {
            return false;
        }
        l3.t3(new Consumer() { // from class: rk1.o
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                v.this.H(l3, (Boolean) obj);
            }
        });
        return true;
    }
}
