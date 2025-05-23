package tencent.im.group_pro_proto.common;

import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class common$ExtInfo extends MessageMicro<common$ExtInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_member_name;
    public final PBUInt64Field channel_create_time;
    public final PBBytesField channel_name;
    public final PBRepeatMessageField<common$DirectMessageMember> direct_message_member;
    public final PBUInt64Field event_version;
    public final PBRepeatMessageField<common$Event> events;
    public common$FreqLimitInfo freq_limit_info;
    public final PBBytesField from_avatar;
    public common$Role from_channel_role_info;
    public common$Role from_guild_role_info;
    public final PBBytesField from_nick;
    public common$Role from_role_info;
    public final PBBytesField guild_name;
    public final PBUInt32Field name_type;
    public final PBUInt32Field notify_type;
    public final PBUInt32Field offline_flag;
    public final PBUInt32Field role_type;
    public common$S2CMsgInfo s2c_msg_info;
    public final PBUInt32Field uint32_timestamp;
    public final PBUInt32Field visibility;

    static {
        String[] strArr = {"from_nick", "guild_name", "channel_name", "visibility", "notify_type", "offline_flag", "name_type", "bytes_member_name", "uint32_timestamp", "event_version", LinkReportConstant$GlobalKey.EVENTS, "from_role_info", "freq_limit_info", "direct_message_member", "from_avatar", "s2c_msg_info", "channel_create_time", "role_type", "from_channel_role_info", "from_guild_role_info"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 56, 66, 72, 80, 90, 98, 106, 114, 122, 130, 136, 144, 154, 162}, strArr, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, 0, byteStringMicro, 0, 0L, null, null, null, null, byteStringMicro, null, 0L, 0, null, null}, common$ExtInfo.class);
    }

    public common$ExtInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.from_nick = PBField.initBytes(byteStringMicro);
        this.guild_name = PBField.initBytes(byteStringMicro);
        this.channel_name = PBField.initBytes(byteStringMicro);
        this.visibility = PBField.initUInt32(0);
        this.notify_type = PBField.initUInt32(0);
        this.offline_flag = PBField.initUInt32(0);
        this.name_type = PBField.initUInt32(0);
        this.bytes_member_name = PBField.initBytes(byteStringMicro);
        this.uint32_timestamp = PBField.initUInt32(0);
        this.event_version = PBField.initUInt64(0L);
        this.events = PBField.initRepeatMessage(common$Event.class);
        this.from_role_info = new common$Role();
        this.freq_limit_info = new common$FreqLimitInfo();
        this.direct_message_member = PBField.initRepeatMessage(common$DirectMessageMember.class);
        this.from_avatar = PBField.initBytes(byteStringMicro);
        this.s2c_msg_info = new common$S2CMsgInfo();
        this.channel_create_time = PBField.initUInt64(0L);
        this.role_type = PBField.initUInt32(0);
        this.from_channel_role_info = new common$Role();
        this.from_guild_role_info = new common$Role();
    }
}
