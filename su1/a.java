package su1;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.data.ChannelMsgEvent;
import com.tencent.mobileqq.guild.message.MessageRecordForAppChannel;
import com.tencent.mobileqq.guild.message.api.IGuildMessageBoxDataService;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import msf.msgcomm.msg_comm$MsgHead;
import tencent.im.group_pro_proto.msgpush.servtype$AppChannelMsg;
import tencent.im.group_pro_proto.msgpush.servtype$EventBody;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {
    private static void a(com.tencent.mobileqq.service.message.a aVar, int i3) {
        ChannelMsgEvent channelMsgEvent = new ChannelMsgEvent();
        channelMsgEvent.channelId = String.valueOf(aVar.f286338a);
        channelMsgEvent.eventType = 3L;
        channelMsgEvent.msgSeq = i3;
        channelMsgEvent.tinyId = String.valueOf(aVar.f286149d);
        ((IGuildMessageBoxDataService) ch.l().getRuntimeService(IGuildMessageBoxDataService.class, "")).addChannelMsgBoxEvent(channelMsgEvent);
        if (QLog.isColorLevel()) {
            QLog.d("GuildAppChannelMsgUtil", 2, "addCalendarEvent:" + channelMsgEvent);
        }
    }

    public static MessageRecordForAppChannel b(String str, String str2, long j3, int i3, String str3, boolean z16) {
        MessageRecordForAppChannel messageRecordForAppChannel = new MessageRecordForAppChannel();
        messageRecordForAppChannel.summary = str;
        messageRecordForAppChannel.f203106msg = str2;
        messageRecordForAppChannel.expireTimeMs = j3;
        messageRecordForAppChannel.schemaType = i3;
        messageRecordForAppChannel.schema = str3;
        messageRecordForAppChannel.isStrongNotify = z16;
        messageRecordForAppChannel.saveData();
        return messageRecordForAppChannel;
    }

    private static MessageRecordForAppChannel c(servtype$EventBody servtype_eventbody, int i3) {
        servtype$AppChannelMsg servtype_appchannelmsg;
        boolean z16;
        if (servtype_eventbody.msg_app_channel.has()) {
            servtype_appchannelmsg = servtype_eventbody.msg_app_channel.get();
            z16 = true;
        } else {
            servtype_appchannelmsg = servtype_eventbody.weak_msg_app_channel.get();
            z16 = false;
        }
        String str = servtype_appchannelmsg.summary.get();
        String str2 = servtype_appchannelmsg.f435944msg.get();
        long j3 = servtype_appchannelmsg.expire_time_ms.get();
        int i16 = servtype_appchannelmsg.schema_type.get();
        String str3 = servtype_appchannelmsg.schema.get();
        if (QLog.isColorLevel()) {
            QLog.i("GuildAppChannelMsgUtil", 1, "decodePBMsgElem, isStrongNotify:" + z16 + "\uff0csummary:" + str + ",msg:" + str2 + ",expireTimeMs:" + j3 + ",schemaType:" + i16 + ",schema:" + str3 + ",seq:" + i3);
        }
        return b(str, str2, j3, i16, str3, z16);
    }

    public static boolean d(servtype$EventBody servtype_eventbody, List<MessageRecord> list, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.service.message.a aVar) {
        int i3;
        msg_comm$MsgHead msg_comm_msghead;
        if (msg_comm_msg != null && (msg_comm_msghead = msg_comm_msg.msg_head) != null) {
            i3 = msg_comm_msghead.msg_seq.get();
        } else {
            i3 = 0;
        }
        MessageRecordForAppChannel c16 = c(servtype_eventbody, i3);
        list.add(c16);
        if (c16.isStrongNotify) {
            a(aVar, i3);
            return true;
        }
        return true;
    }
}
