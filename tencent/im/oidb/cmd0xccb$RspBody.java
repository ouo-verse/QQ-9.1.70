package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xccb$RspBody extends MessageMicro<cmd0xccb$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 56, 64, 74, 80, 88, 98}, new String[]{"type", "dest_uin", "group_code", "c2c_msg", "group_msg", IPreloadServiceProxy.KEY_RESID, "c2c_type", "service_type", "local_msg", "guild_id", "channel_id", "guild_msg"}, new Object[]{0, 0L, 0L, null, null, ByteStringMicro.EMPTY, 0, 0, null, 0L, 0L, null}, cmd0xccb$RspBody.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt64Field dest_uin = PBField.initUInt64(0);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBRepeatMessageField<cmd0xccb$C2cMsgInfo> c2c_msg = PBField.initRepeatMessage(cmd0xccb$C2cMsgInfo.class);
    public final PBRepeatMessageField<cmd0xccb$GroupMsgInfo> group_msg = PBField.initRepeatMessage(cmd0xccb$GroupMsgInfo.class);
    public final PBBytesField res_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field c2c_type = PBField.initUInt32(0);
    public final PBUInt32Field service_type = PBField.initUInt32(0);
    public cmd0xccb$LocalMsgInfo local_msg = new cmd0xccb$LocalMsgInfo();
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBRepeatMessageField<cmd0xccb$GuildMsgInfo> guild_msg = PBField.initRepeatMessage(cmd0xccb$GuildMsgInfo.class);
}
