package tencent.im.oidb.cmd0x8e4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.hotchat.Common$WifiPOIInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8e4$RspBody extends MessageMicro<oidb_0x8e4$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public Common$WifiPOIInfo poi_info;
    public final PBRepeatMessageField<oidb_0x8e4$PlayerState> rpt_msg_player_state;
    public final PBRepeatField<Long> rpt_uint64_invite_uin;
    public final PBRepeatField<Long> rpt_uint64_kick_uin;
    public final PBBytesField string_err_msg;
    public final PBBytesField string_err_title;
    public final PBBytesField string_invite_id;
    public final PBUInt32Field uint32_max_member_num;
    public final PBUInt32Field uint32_refresh_interval;
    public final PBUInt32Field uint32_zone_id;
    public final PBUInt64Field uint64_leader_uin = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 48, 56, 66, 74, 82, 88}, new String[]{"uint64_leader_uin", "rpt_uint64_invite_uin", "poi_info", "uint32_refresh_interval", "string_invite_id", "rpt_uint64_kick_uin", "uint32_max_member_num", "rpt_msg_player_state", "string_err_title", "string_err_msg", "uint32_zone_id"}, new Object[]{0L, 0L, null, 0, byteStringMicro, 0L, 0, null, byteStringMicro, byteStringMicro, 0}, oidb_0x8e4$RspBody.class);
    }

    public oidb_0x8e4$RspBody() {
        PBUInt64Field pBUInt64Field = PBUInt64Field.__repeatHelper__;
        this.rpt_uint64_invite_uin = PBField.initRepeat(pBUInt64Field);
        this.poi_info = new Common$WifiPOIInfo();
        this.uint32_refresh_interval = PBField.initUInt32(0);
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.string_invite_id = PBField.initBytes(byteStringMicro);
        this.rpt_uint64_kick_uin = PBField.initRepeat(pBUInt64Field);
        this.uint32_max_member_num = PBField.initUInt32(0);
        this.rpt_msg_player_state = PBField.initRepeatMessage(oidb_0x8e4$PlayerState.class);
        this.string_err_title = PBField.initBytes(byteStringMicro);
        this.string_err_msg = PBField.initBytes(byteStringMicro);
        this.uint32_zone_id = PBField.initUInt32(0);
    }
}
