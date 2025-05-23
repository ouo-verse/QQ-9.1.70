package uh2;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqnt.kernel.api.j;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProContact;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildFeedDraft;
import com.tencent.qqnt.kernelgpro.nativeinterface.IFetchNavigateInfoCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGuildDraftCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGuildGetMsgAbstractsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildFetchChannelLatestSeqCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildHelperNotifySwitchOperateCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildInteractiveNotificationCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener;
import com.tencent.qqnt.kernelgpro.nativeinterface.IUnreadCntCallback;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H&J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H&J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H&J \u0010\u0011\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH&J\u001c\u0010\u0014\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J.\u0010\u0018\u001a\u00020\u00022\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J\u001c\u0010\u0019\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J\u001c\u0010\u001a\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J\u001c\u0010\u001b\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J\u001c\u0010\u001d\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u001cH&J\u001c\u0010\u001f\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u001eH&J\u001c\u0010#\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u0013\u001a\u0004\u0018\u00010\"H&J\u001c\u0010$\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\"H&J\u001c\u0010%\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\"H&J\u0012\u0010&\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\"H&J<\u0010)\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010 2\u001e\u0010'\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010\u0015j\f\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u0001`\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010(H&J$\u0010,\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010+\u001a\u00020*2\b\u0010\u0013\u001a\u0004\u0018\u00010\"H&J\u0012\u0010-\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&J$\u0010.\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010+\u001a\u00020*2\b\u0010\u0013\u001a\u0004\u0018\u00010\"H&J$\u0010/\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010+\u001a\u00020*2\b\u0010\u0013\u001a\u0004\u0018\u00010\"H&J6\u00102\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u00100\u001a\u00020\u000f2\u001a\u00101\u001a\u0016\u0012\u0004\u0012\u00020*\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020*\u0018\u0001`\u0016H&J \u00105\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\"H&J\u0010\u00107\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u000206H&J\b\u00108\u001a\u00020\u0002H&J$\u0010<\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u00109\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010:H&J \u0010>\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\"H&J2\u0010D\u001a\u00020\u00022\u0006\u0010?\u001a\u00020 2\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020 2\u0006\u0010C\u001a\u00020B2\b\u0010\u0013\u001a\u0004\u0018\u00010\"H&J*\u0010F\u001a\u00020\u00022\u0006\u0010?\u001a\u00020 2\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020 2\b\u0010\u0013\u001a\u0004\u0018\u00010EH&J*\u0010H\u001a\u00020\u00022\u0006\u0010G\u001a\u00020 2\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020 2\b\u0010\u0013\u001a\u0004\u0018\u00010\"H&\u00a8\u0006I"}, d2 = {"Luh2/c;", "Lcom/tencent/qqnt/kernel/api/j;", "", "destroy", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelGProGuildMsgListener;", "r", "msgListener", "w0", "listener", "addKernelGProGuildMsgListener", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProContact;", "peer", "", "msgTabFocus", "", "activeStatus", "setFocusSession", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IUnreadCntCallback;", "cb", "G", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "peers", "getUnreadCntInfo", "p", HippyTKDListViewAdapter.X, "P", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGuildFetchChannelLatestSeqCallback;", "getFirstUnreadCommonMsg", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IFetchNavigateInfoCallback;", "getNavigateInfo", "", "guildId", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGuildOperateCallback;", "setGProGuildMsgRead", "setGProMsgRead", "setGProLocalMsgRead", "setGProAllDirectMsgRead", "channelIds", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGuildGetMsgAbstractsCallback;", "getMsgAbstracts", "", "msgId", "E", "getChannelEventFlow", "deleteRecallMsg", "deleteRecallMsgForLocal", "screenType", "msgSeqList", "setCurOnScreenMsg", "noticeType", "value", "setGuildHelperNotifySwitch", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGuildHelperNotifySwitchOperateCallback;", "getGuildHelperNotifySwitch", "forceShowGuildHelperNode", "type", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGuildInteractiveNotificationCallback;", "callback", "getGuildInteractiveNotification", "readScene", "clearGuildReadSceneV2", "guildID", "draftType", "draftKey", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGuildFeedDraft;", "draft", "setGuildFeedDraft", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGuildDraftCallback;", "getGuildFeedDraft", "draftId", "deleteGuildFeedDraft", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface c extends j {
    void E(@Nullable GProContact peer, long msgId, @Nullable IGuildOperateCallback cb5);

    void G(@Nullable GProContact peer, @Nullable IUnreadCntCallback cb5);

    void P(@Nullable GProContact peer, @Nullable IUnreadCntCallback cb5);

    void addKernelGProGuildMsgListener(@NotNull IKernelGProGuildMsgListener listener);

    void clearGuildReadSceneV2(@NotNull GProContact peer, int readScene, @NotNull IGuildOperateCallback cb5);

    void deleteGuildFeedDraft(@NotNull String draftId, int draftType, @NotNull String draftKey, @Nullable IGuildOperateCallback cb5);

    void deleteRecallMsg(@Nullable GProContact peer, long msgId, @Nullable IGuildOperateCallback cb5);

    void deleteRecallMsgForLocal(@Nullable GProContact peer, long msgId, @Nullable IGuildOperateCallback cb5);

    void destroy();

    void forceShowGuildHelperNode();

    void getChannelEventFlow(@Nullable GProContact peer);

    void getFirstUnreadCommonMsg(@Nullable GProContact peer, @Nullable IGuildFetchChannelLatestSeqCallback cb5);

    void getGuildFeedDraft(@NotNull String guildID, int draftType, @NotNull String draftKey, @Nullable IGProGuildDraftCallback cb5);

    void getGuildHelperNotifySwitch(@NotNull IGuildHelperNotifySwitchOperateCallback cb5);

    void getGuildInteractiveNotification(@Nullable String guildId, int type, @Nullable IGuildInteractiveNotificationCallback callback);

    void getMsgAbstracts(@Nullable String guildId, @Nullable ArrayList<String> channelIds, @Nullable IGProGuildGetMsgAbstractsCallback cb5);

    void getNavigateInfo(@Nullable GProContact peer, @Nullable IFetchNavigateInfoCallback cb5);

    void getUnreadCntInfo(@Nullable ArrayList<GProContact> peers, @Nullable IUnreadCntCallback cb5);

    void p(@Nullable GProContact peer, @Nullable IUnreadCntCallback cb5);

    @Nullable
    IKernelGProGuildMsgListener r();

    void setCurOnScreenMsg(@Nullable GProContact peer, int screenType, @Nullable ArrayList<Long> msgSeqList);

    void setFocusSession(@NotNull GProContact peer, boolean msgTabFocus, int activeStatus);

    void setGProAllDirectMsgRead(@Nullable IGuildOperateCallback cb5);

    void setGProGuildMsgRead(@Nullable String guildId, @Nullable IGuildOperateCallback cb5);

    void setGProLocalMsgRead(@Nullable GProContact peer, @Nullable IGuildOperateCallback cb5);

    void setGProMsgRead(@Nullable GProContact peer, @Nullable IGuildOperateCallback cb5);

    void setGuildFeedDraft(@NotNull String guildID, int draftType, @NotNull String draftKey, @NotNull GProGuildFeedDraft draft, @Nullable IGuildOperateCallback cb5);

    void setGuildHelperNotifySwitch(int noticeType, int value, @NotNull IGuildOperateCallback cb5);

    void w0(@Nullable IKernelGProGuildMsgListener msgListener);

    void x(@Nullable GProContact peer, @Nullable IUnreadCntCallback cb5);

    void z(@NotNull IKernelGProGuildMsgListener listener);
}
