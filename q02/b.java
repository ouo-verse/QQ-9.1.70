package q02;

import com.tencent.mobileqq.guild.message.lastmsg.LastMessage;
import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import com.tencent.mobileqq.guild.summary.GuildSummaryText;
import com.tencent.qqnt.kernelpublic.nativeinterface.CalendarElement;
import java.util.ArrayList;
import java.util.List;
import ju1.ScheduleExtra;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lq02/b;", "Lhu1/a;", "Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage;", "lastMessage", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo;", "unreadInfo", "", "Lcom/tencent/mobileqq/guild/summary/GuildSummaryText;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b implements hu1.a {
    @Override // hu1.a
    @NotNull
    public List<GuildSummaryText> a(@NotNull LastMessage lastMessage, @NotNull UnreadInfo unreadInfo) {
        ScheduleExtra scheduleExtra;
        boolean z16;
        List<GuildSummaryText> emptyList;
        List<GuildSummaryText> emptyList2;
        Intrinsics.checkNotNullParameter(lastMessage, "lastMessage");
        Intrinsics.checkNotNullParameter(unreadInfo, "unreadInfo");
        if (lastMessage.getType() != 19) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return emptyList2;
        }
        ju1.a customData = lastMessage.getCustomData();
        CalendarElement calendarElement = null;
        if (customData instanceof ScheduleExtra) {
            scheduleExtra = (ScheduleExtra) customData;
        } else {
            scheduleExtra = null;
        }
        if (scheduleExtra != null) {
            calendarElement = scheduleExtra.getCalendarElement();
        }
        if (calendarElement == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        String summary = scheduleExtra.getCalendarElement().summary;
        int subType = scheduleExtra.getSubType();
        ArrayList arrayList = new ArrayList();
        boolean z17 = false;
        if (summary != null && summary.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            GuildSummaryText.TextStyle textStyle = GuildSummaryText.TextStyle.WEAK_BOLD;
            if (subType == 3) {
                if (unreadInfo.getRelatedToMeString().length() == 0) {
                    z17 = true;
                }
                if (z17 && unreadInfo.j() > 0) {
                    textStyle = GuildSummaryText.TextStyle.HIGHLIGHT_BOLD;
                }
            }
            Intrinsics.checkNotNullExpressionValue(summary, "summary");
            arrayList.add(new GuildSummaryText(summary, textStyle));
        }
        arrayList.add(new GuildSummaryText(lastMessage.getContent(), GuildSummaryText.TextStyle.NORMAL));
        return arrayList;
    }
}
