package ws0;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.guild.aio.chosen.data.GuildChosenMsgListDataManager;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProTopMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lws0/a;", "Lcom/tencent/guild/aio/chosen/data/GuildChosenMsgListDataManager;", "Lcom/tencent/guild/aio/chosen/data/GuildChosenMsgListDataManager$RefreshType;", "refreshType", "", "k", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "f", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "g", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "<init>", "(Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;)V", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a extends GuildChosenMsgListDataManager {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Contact contact;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BaseQQAppInterface app;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Contact contact) {
        super(contact);
        Intrinsics.checkNotNullParameter(contact, "contact");
        this.contact = contact;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.business.BaseQQAppInterface");
        this.app = (BaseQQAppInterface) peekAppRuntime;
    }

    @Override // com.tencent.guild.aio.chosen.data.GuildChosenMsgListDataManager
    public void k(@NotNull GuildChosenMsgListDataManager.RefreshType refreshType) {
        Object lastOrNull;
        long j3;
        ArrayList<Long> arrayList;
        Intrinsics.checkNotNullParameter(refreshType, "refreshType");
        IGProChannelInfo channelInfo = ((IGPSService) this.app.getRuntimeService(IGPSService.class)).getChannelInfo(this.contact.peerUid);
        if (channelInfo == null) {
            QLog.d("GuildMediaChosenMsgListDataManager", 2, "queryTopMsgForChannel, IGProChannelInfo==null, return null");
            return;
        }
        ArrayList<IGProTopMsg> topMsgList = channelInfo.getTopMsgList();
        Intrinsics.checkNotNullExpressionValue(topMsgList, "info.topMsgList");
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) topMsgList);
        IGProTopMsg iGProTopMsg = (IGProTopMsg) lastOrNull;
        if (iGProTopMsg != null) {
            j3 = iGProTopMsg.getTopMsgSeq();
        } else {
            j3 = 0;
        }
        if (j3 > 0) {
            arrayList = CollectionsKt__CollectionsKt.arrayListOf(Long.valueOf(j3));
        } else {
            arrayList = new ArrayList<>();
        }
        h(arrayList, refreshType);
    }
}
