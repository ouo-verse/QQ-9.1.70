package zp0;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.google.gson.JsonParseException;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager;
import com.tencent.guild.aio.msglist.holder.component.nick.o;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.guild.api.msglist.IGuildAIOMultiActionApi;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.util.at;
import com.tencent.mobileqq.guild.util.qqui.c;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.qqnt.kernel.nativeinterface.ArkElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.ReplyElement;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringBuilderJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qr0.d;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001>B\t\b\u0002\u00a2\u0006\u0004\b<\u0010=J.\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\n\u001a\u00060\bj\u0002`\tH\u0002J\u0016\u0010\u000f\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0002J\u001a\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u001e\u0010\u001a\u001a\u00020\u00192\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\u001b\u001a\u00020\u00192\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0002J\u0016\u0010 \u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0002J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J*\u0010%\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\"\u001a\u00060\bj\u0002`\t2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040#H\u0002J,\u0010)\u001a\u00020\u000b2\n\u0010\"\u001a\u00060\bj\u0002`\t2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0004H\u0002J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010,\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0004H\u0002J\u001c\u0010.\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060\rJ\u0018\u00100\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010/\u001a\u00020\u0013J&\u00101\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\b\b\u0002\u0010/\u001a\u00020\u0013J\u001c\u00104\u001a\u00020\u000b2\u0006\u00103\u001a\u0002022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\rJ\u001c\u00106\u001a\u00020\u000b2\u0006\u00103\u001a\u0002022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002050\rJ\u000e\u00107\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0017\u0010\u0017\u001a\u0002088\u0006\u00a2\u0006\f\n\u0004\b%\u00109\u001a\u0004\b:\u0010;\u00a8\u0006?"}, d2 = {"Lzp0/b;", "", "Lcom/tencent/aio/api/runtime/a;", "context", "", RemoteMessageConst.MessageBody.MSG_CONTENT, "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "", "c", "", TabPreloadItem.TAB_NAME_MESSAGE, "r", "chatuin", "Landroid/os/Bundle;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "o", "evilUin", "Lmqq/app/AppRuntime;", "appRuntime", "k", "", "f", "g", "msgCount", "e", "msg", "y", ReportConstant.COSTREPORT_PREFIX, "p", "tempSb", "Ljava/util/ArrayList;", "msgContentList", "b", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "content", QQBrowserActivity.KEY_MSG_TYPE, "d", DomainData.DOMAIN_NAME, AdMetricTag.Report.TYPE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "multiMsgList", "t", "scene", "w", "u", "Lorg/json/JSONArray;", "jsonArray", h.F, "Lzp0/b$a;", "i", "l", "Lmqq/app/MobileQQ;", "Lmqq/app/MobileQQ;", "j", "()Lmqq/app/MobileQQ;", "<init>", "()V", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f452962a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MobileQQ appRuntime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\"\u0010\u001a\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000eR$\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u0010\u0010\u001c\"\u0004\b\u0017\u0010\u001d\u00a8\u0006!"}, d2 = {"Lzp0/b$a;", "", "Lorg/json/JSONObject;", "f", "jsonObject", "", "a", "", "toString", "", "J", "c", "()J", "e", "(J)V", "msgSeq", "b", "getMsgTime", "setMsgTime", "msgTime", "getMsgRandom", "setMsgRandom", "msgRandom", "d", "getResult", "setResult", "result", "Ljava/lang/String;", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "channelUin", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private long msgSeq;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private long msgTime;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private long msgRandom;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private long result;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String channelUin;

        public final void a(@NotNull JSONObject jsonObject) {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            try {
                this.channelUin = (String) jsonObject.get("channelUin");
                Intrinsics.checkNotNull(jsonObject.get("msgRandom"), "null cannot be cast to non-null type kotlin.Int");
                this.msgRandom = ((Integer) r1).intValue();
                Intrinsics.checkNotNull(jsonObject.get("msgSeq"), "null cannot be cast to non-null type kotlin.Int");
                this.msgSeq = ((Integer) r1).intValue();
                Intrinsics.checkNotNull(jsonObject.get("msgTime"), "null cannot be cast to non-null type kotlin.Int");
                this.msgTime = ((Integer) r1).intValue();
                Intrinsics.checkNotNull(jsonObject.get("result"), "null cannot be cast to non-null type kotlin.Int");
                this.result = ((Integer) r4).intValue();
            } catch (JSONException unused) {
            }
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getChannelUin() {
            return this.channelUin;
        }

        /* renamed from: c, reason: from getter */
        public final long getMsgSeq() {
            return this.msgSeq;
        }

        public final void d(@Nullable String str) {
            this.channelUin = str;
        }

        public final void e(long j3) {
            this.msgSeq = j3;
        }

        @NotNull
        public final JSONObject f() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("channelUin", this.channelUin);
            jSONObject.put("msgRandom", (int) this.msgRandom);
            jSONObject.put("msgSeq", (int) this.msgSeq);
            jSONObject.put("msgTime", (int) this.msgTime);
            jSONObject.put("result", (int) this.result);
            return jSONObject;
        }

        @NotNull
        public String toString() {
            return " channelUin = " + this.channelUin + ", msgRandom = " + this.msgRandom + ", msgSeq = " + this.msgSeq + ", msgTime = " + this.msgTime + ", result = " + this.result;
        }
    }

    static {
        MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
        Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
        appRuntime = sMobileQQ;
    }

    b() {
    }

    private final void b(GuildMsgItem msgItem, StringBuilder tempSb, ArrayList<String> msgContentList) {
        ArrayList<MsgElement> arrayListOf;
        String obj;
        String str;
        String senderUin = msgItem.getMsgRecord().senderUid;
        Iterator<MsgElement> it = msgItem.getMsgRecord().elements.iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            int i3 = next.elementType;
            if (i3 == 1) {
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(next);
                obj = ((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).parseEmotionText(arrayListOf).toString();
                str = "1";
            } else if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            obj = null;
                            str = null;
                        } else {
                            obj = next.videoElement.fileName;
                            str = "5";
                        }
                    } else {
                        obj = next.pttElement.fileName;
                        str = "7";
                    }
                } else {
                    obj = next.fileElement.fileName;
                    str = "6";
                }
            } else {
                obj = next.picElement.fileName;
                str = "2";
            }
            if (obj != null && str != null) {
                Intrinsics.checkNotNullExpressionValue(senderUin, "senderUin");
                d(tempSb, senderUin, obj, str);
                msgContentList.add(tempSb.toString());
                if (msgContentList.size() > 50) {
                    return;
                }
            }
        }
    }

    private final void c(com.tencent.aio.api.runtime.a context, String msgContent, GuildMsgItem msgItem, StringBuilder sb5) {
        o.Companion companion = o.INSTANCE;
        FragmentActivity activity = context.c().getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type android.content.Context");
        String b16 = companion.b(activity, msgItem.getMsgRecord().msgTime * 1000);
        sb5.append(iq0.a.t(msgItem));
        sb5.append(" ");
        sb5.append(b16);
        sb5.append("\n");
        sb5.append(msgContent);
        sb5.append("\n");
    }

    private final void d(StringBuilder tempSb, String senderUin, String content, String msgType) {
        tempSb.setLength(0);
        tempSb.append("[");
        tempSb.append("uin=");
        tempSb.append(senderUin);
        tempSb.append(";");
        tempSb.append("content=");
        tempSb.append(content);
        tempSb.append(";");
        tempSb.append("type=");
        tempSb.append(msgType);
        tempSb.append("]");
    }

    private final boolean e(int msgCount, com.tencent.aio.api.runtime.a context) {
        if (msgCount == 0) {
            y(context, appRuntime.getString(R.string.f139030a6));
            return false;
        }
        if (msgCount > 50) {
            MobileQQ mobileQQ = appRuntime;
            y(context, mobileQQ.getString(R.string.f139050a8) + "50" + mobileQQ.getString(R.string.f139060a9));
            return false;
        }
        return true;
    }

    private final boolean f(List<? extends GuildMsgItem> msgList, com.tencent.aio.api.runtime.a context) {
        if (e(msgList.size(), context) && g(msgList, context)) {
            return true;
        }
        return false;
    }

    private final boolean g(List<? extends GuildMsgItem> msgList, com.tencent.aio.api.runtime.a context) {
        String str;
        String str2 = msgList.get(0).getMsgRecord().senderUid;
        Intrinsics.checkNotNullExpressionValue(str2, "msgList[0].msgRecord.senderUid");
        Iterator<? extends GuildMsgItem> it = msgList.iterator();
        while (it.hasNext()) {
            if (!Intrinsics.areEqual(it.next().getMsgRecord().senderUid, str2)) {
                y(context, appRuntime.getString(R.string.f139040a7));
                return false;
            }
        }
        IGPSService d16 = at.d();
        if (d16 != null) {
            str = d16.getSelfTinyId();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str2, str)) {
            y(context, "\u4e0d\u80fd\u9488\u5bf9\u81ea\u5df1\u7684\u804a\u5929\u8bb0\u5f55\u8fdb\u884c\u4e3e\u62a5");
            return false;
        }
        return true;
    }

    private final String k(String evilUin, AppRuntime appRuntime2) {
        return ((IGuildAIOMultiActionApi) QRoute.api(IGuildAIOMultiActionApi.class)).getBuddyFlag(evilUin, appRuntime2);
    }

    private final String m(GuildMsgItem msgItem, String reportType) {
        switch (reportType.hashCode()) {
            case 49:
                if (reportType.equals("1")) {
                    return p(msgItem);
                }
                return "";
            case 50:
                if (reportType.equals("2")) {
                    String str = msgItem.getMsgRecord().elements.get(0).picElement.fileName;
                    Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.elements[0].picElement.fileName");
                    return str;
                }
                return "";
            case 51:
            case 52:
            default:
                return "";
            case 53:
                if (reportType.equals("5")) {
                    String str2 = msgItem.getMsgRecord().elements.get(0).videoElement.fileName;
                    Intrinsics.checkNotNullExpressionValue(str2, "msgItem.msgRecord.elemen\u2026[0].videoElement.fileName");
                    return str2;
                }
                return "";
            case 54:
                if (reportType.equals("6")) {
                    String str3 = msgItem.getMsgRecord().elements.get(0).fileElement.fileName;
                    Intrinsics.checkNotNullExpressionValue(str3, "msgItem.msgRecord.elements[0].fileElement.fileName");
                    return str3;
                }
                return "";
            case 55:
                if (reportType.equals("7")) {
                    String str4 = msgItem.getMsgRecord().elements.get(0).pttElement.fileName;
                    Intrinsics.checkNotNullExpressionValue(str4, "msgItem.msgRecord.elements[0].pttElement.fileName");
                    return str4;
                }
                return "";
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0016. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String n(GuildMsgItem msgItem) {
        int viewType = msgItem.getViewType();
        switch (viewType) {
            case 2:
            case 3:
                return "1000";
            case 4:
            case 5:
                return "2";
            case 6:
            case 7:
                return "1";
            case 8:
            case 9:
                return "6";
            case 10:
            case 11:
                return "5";
            case 12:
            case 13:
                return "7";
            default:
                switch (viewType) {
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                        break;
                    default:
                        return "-1";
                }
        }
    }

    private final int o() {
        return TVKEventId.PLAYER_STATE_PLAY_REOPEN_END;
    }

    private final String p(GuildMsgItem msgItem) {
        List filterNotNull;
        ArrayList<MsgElement> arrayList = new ArrayList<>();
        ArrayList<MsgElement> elements = msgItem.getMsgRecord().elements;
        if (elements != null) {
            Intrinsics.checkNotNullExpressionValue(elements, "elements");
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(elements);
            if (filterNotNull != null) {
                Iterator it = filterNotNull.iterator();
                while (it.hasNext()) {
                    arrayList.add((MsgElement) it.next());
                }
            }
        }
        if (arrayList.isEmpty()) {
            return "";
        }
        return ((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).parseEmotionText(arrayList).toString();
    }

    private final Bundle q(com.tencent.aio.api.runtime.a context, String chatuin) {
        Bundle bundle = new Bundle();
        bundle.putString("chatuin", chatuin);
        bundle.putInt("chattype", 10014);
        bundle.putBoolean("isdirectmsg", com.tencent.guild.aio.util.ex.a.h(context));
        return bundle;
    }

    private final String r(List<? extends GuildMsgItem> msgList) {
        StringBuilder sb5 = new StringBuilder();
        ArrayList<String> arrayList = new ArrayList<>();
        for (GuildMsgItem guildMsgItem : msgList) {
            String str = guildMsgItem.getMsgRecord().senderUid;
            Intrinsics.checkNotNullExpressionValue(str, "msg.msgRecord.senderUid");
            String n3 = n(guildMsgItem);
            if (!Intrinsics.areEqual(n3, "-1")) {
                if (Intrinsics.areEqual(n3, "1000")) {
                    b(guildMsgItem, sb5, arrayList);
                } else {
                    d(sb5, str, m(guildMsgItem, n3), n3);
                    arrayList.add(sb5.toString());
                }
            }
            if (arrayList.size() >= 50) {
                break;
            }
        }
        StringsKt__StringBuilderJVMKt.clear(sb5);
        sb5.append("chatmsg:");
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            sb5.append(it.next());
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "tempSb.toString()");
        return sb6;
    }

    private final String s(List<? extends GuildMsgItem> msgList) {
        JSONArray jSONArray = new JSONArray();
        h(jSONArray, msgList);
        String jSONArray2 = jSONArray.toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray2, "jsonArray.toString()");
        return jSONArray2;
    }

    public static /* synthetic */ void v(b bVar, com.tencent.aio.api.runtime.a aVar, List list, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = bVar.o();
        }
        bVar.u(aVar, list, i3);
    }

    public static /* synthetic */ boolean x(b bVar, com.tencent.aio.api.runtime.a aVar, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = bVar.o();
        }
        return bVar.w(aVar, i3);
    }

    private final void y(com.tencent.aio.api.runtime.a context, String msg2) {
        c.b(context.c().getActivity(), 230, null, msg2, "", appRuntime.getString(R.string.f139020a5), new DialogInterface.OnClickListener() { // from class: zp0.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                b.z(dialogInterface, i3);
            }
        }, null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    public final void h(@NotNull JSONArray jsonArray, @NotNull List<? extends GuildMsgItem> msgList) {
        Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        for (GuildMsgItem guildMsgItem : msgList) {
            a aVar = new a();
            IGuildAIOMultiActionApi iGuildAIOMultiActionApi = (IGuildAIOMultiActionApi) QRoute.api(IGuildAIOMultiActionApi.class);
            String str = guildMsgItem.getMsgRecord().channelId;
            Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.channelId");
            aVar.d(iGuildAIOMultiActionApi.newReportPluginEncrypt(str));
            aVar.e(guildMsgItem.getMsgRecord().msgSeq);
            try {
                jsonArray.mo162put(aVar.f());
            } catch (JsonParseException unused) {
            }
        }
    }

    public final void i(@NotNull JSONArray jsonArray, @NotNull List<a> msgList) {
        Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        Iterator<a> it = msgList.iterator();
        while (it.hasNext()) {
            try {
                jsonArray.mo162put(it.next().f());
            } catch (JsonParseException unused) {
            }
        }
    }

    @NotNull
    public final MobileQQ j() {
        return appRuntime;
    }

    @NotNull
    public final String l(@NotNull GuildMsgItem msgItem) {
        ArrayList<MsgElement> arrayListOf;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        StringBuilder sb5 = new StringBuilder();
        Iterator<MsgElement> it = msgItem.getMsgRecord().elements.iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            int i3 = next.elementType;
            if (i3 == 1) {
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(next);
                sb5.append(((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).parseEmotionText(arrayListOf));
            } else if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 5) {
                        sb5.append(appRuntime.getString(R.string.f139500bf));
                    }
                } else {
                    sb5.append(appRuntime.getString(R.string.f139470bc));
                }
            } else {
                sb5.append(appRuntime.getString(R.string.f139480bd));
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "tempSb.toString()");
        return sb6;
    }

    public final void t(@NotNull com.tencent.aio.api.runtime.a context, @NotNull List<? extends GuildMsgItem> multiMsgList) {
        ReplyElement replyElement;
        String str;
        ArkElement arkElement;
        TextElement textElement;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(multiMsgList, "multiMsgList");
        ArrayList arrayList = new ArrayList(multiMsgList);
        GuildMultiMsgManager.INSTANCE.a().o(arrayList);
        StringBuilder sb5 = new StringBuilder();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            GuildMsgItem msgItem = (GuildMsgItem) arrayList.get(i3);
            Intrinsics.checkNotNullExpressionValue(msgItem, "msgItem");
            if (d.o(msgItem)) {
                str = p(msgItem);
            } else if (d.m(msgItem)) {
                str = appRuntime.getString(R.string.f139480bd);
            } else if (msgItem.getMsgRecord().msgType == 7) {
                str = appRuntime.getString(R.string.f139500bf);
            } else if (msgItem.getMsgRecord().msgType == 3) {
                str = appRuntime.getString(R.string.f139470bc);
            } else if (msgItem.isMixMsg()) {
                str = l(msgItem);
            } else {
                String str2 = null;
                if (d.g(msgItem)) {
                    ArrayList<MsgElement> arrayList2 = msgItem.getMsgRecord().elements;
                    Intrinsics.checkNotNullExpressionValue(arrayList2, "msgItem.msgRecord.elements");
                    String str3 = null;
                    for (MsgElement msgElement : arrayList2) {
                        if (msgElement != null && (textElement = msgElement.textElement) != null) {
                            Intrinsics.checkNotNullExpressionValue(textElement, "textElement");
                            String str4 = textElement.content;
                            if (str4 == null) {
                                str4 = null;
                            }
                            str3 = ((Object) str3) + str4;
                        }
                    }
                    str = str3;
                } else {
                    if (msgItem.getMsgRecord().msgType == 11) {
                        ArrayList<MsgElement> arrayList3 = msgItem.getMsgRecord().elements;
                        Intrinsics.checkNotNullExpressionValue(arrayList3, "msgItem.msgRecord.elements");
                        for (MsgElement msgElement2 : arrayList3) {
                            if (msgElement2 != null && (arkElement = msgElement2.arkElement) != null) {
                                Intrinsics.checkNotNullExpressionValue(arkElement, "arkElement");
                                str2 = new JSONObject(msgElement2.arkElement.bytesData).optString("prompt");
                            }
                        }
                    } else if (msgItem.getMsgRecord().msgType == 9) {
                        ArrayList<MsgElement> arrayList4 = msgItem.getMsgRecord().elements;
                        Intrinsics.checkNotNullExpressionValue(arrayList4, "msgItem.msgRecord.elements");
                        for (MsgElement msgElement3 : arrayList4) {
                            if (msgElement3 != null && (replyElement = msgElement3.replyElement) != null) {
                                Intrinsics.checkNotNullExpressionValue(replyElement, "replyElement");
                                str2 = f452962a.p(msgItem);
                            }
                        }
                    }
                    str = str2;
                }
            }
            if (str != null) {
                c(context, str, msgItem, sb5);
                if (i3 != arrayList.size() - 1) {
                    sb5.append("\n");
                }
            }
        }
        if (arrayList.isEmpty()) {
            MobileQQ mobileQQ = appRuntime;
            QQToast.makeText(mobileQQ, mobileQQ.getString(R.string.f139310ax), 0).show(mobileQQ.getResources().getDimensionPixelSize(ImmersiveUtils.getStatusBarHeight(mobileQQ) + R.dimen.f158964cd4));
            return;
        }
        MobileQQ mobileQQ2 = appRuntime;
        Object systemService = mobileQQ2.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardMonitor.setPrimaryClip((ClipboardManager) systemService, ClipData.newPlainText("simple text", sb5.toString()));
        QQToast.makeText(mobileQQ2, mobileQQ2.getString(R.string.f139260as), 0).show(mobileQQ2.getResources().getDimensionPixelSize(ImmersiveUtils.getStatusBarHeight(mobileQQ2) + R.dimen.f158964cd4));
    }

    public final void u(@NotNull com.tencent.aio.api.runtime.a context, @NotNull List<? extends GuildMsgItem> msgList, int scene) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        AppRuntime appRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
        String selfUin = appRuntime2.getCurrentAccountUin();
        String j3 = context.g().r().c().j();
        String evilUin = msgList.get(0).getMsgRecord().senderUid;
        Bundle q16 = q(context, j3);
        String f16 = context.g().r().c().f();
        Intrinsics.checkNotNullExpressionValue(evilUin, "evilUin");
        Intrinsics.checkNotNullExpressionValue(appRuntime2, "appRuntime");
        String k3 = k(evilUin, appRuntime2);
        byte[] bytes = s(msgList).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        String c16 = com.tencent.guild.aio.util.b.c(bytes, 2);
        Intrinsics.checkNotNullExpressionValue(c16, "encodeToString(msgJson.t\u2026ay(), Base64Util.NO_WRAP)");
        String r16 = r(msgList);
        IGuildAIOMultiActionApi iGuildAIOMultiActionApi = (IGuildAIOMultiActionApi) QRoute.api(IGuildAIOMultiActionApi.class);
        FragmentActivity activity = context.c().getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type android.app.Activity");
        Intrinsics.checkNotNullExpressionValue(selfUin, "selfUin");
        iGuildAIOMultiActionApi.actionSheetReport(activity, evilUin, k3, f16, selfUin, scene, r16, msgList.size(), c16, q16);
    }

    public final boolean w(@NotNull com.tencent.aio.api.runtime.a context, int scene) {
        Intrinsics.checkNotNullParameter(context, "context");
        List<GuildMsgItem> g16 = GuildMultiMsgManager.INSTANCE.a().g(new GuildMultiMsgManager.d(context.g().r().c().j(), com.tencent.guild.aio.util.ex.a.d(context)));
        if (!f(g16, context)) {
            return false;
        }
        u(context, g16, scene);
        return true;
    }
}
