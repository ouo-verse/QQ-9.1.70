package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class nt_register_proxy$PushParams extends MessageMicro<nt_register_proxy$PushParams> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50, 58, 64}, new String[]{"result", "err_msg", "seq", "online_infos", "pc_stat_info", "udc_flag", "sns_info", "game_box_appids"}, new Object[]{0, ByteStringMicro.EMPTY, 0, null, null, null, null, 0L}, nt_register_proxy$PushParams.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBRepeatMessageField<nt_register_proxy$OnlineInfo> online_infos = PBField.initRepeatMessage(nt_register_proxy$OnlineInfo.class);
    public nt_register_proxy$PCStatInfo pc_stat_info = new nt_register_proxy$PCStatInfo();
    public nt_register_proxy$UdcFlag udc_flag = new nt_register_proxy$UdcFlag();
    public nt_register_proxy$SnsInfo sns_info = new MessageMicro<nt_register_proxy$SnsInfo>() { // from class: tencent.im.msg.nt_register_proxy$SnsInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"not_disturb_list", "hide_friend_list"}, new Object[]{0L, 0L}, nt_register_proxy$SnsInfo.class);
        public final PBRepeatField<Long> hide_friend_list;
        public final PBRepeatField<Long> not_disturb_list;

        {
            PBUInt64Field pBUInt64Field = PBUInt64Field.__repeatHelper__;
            this.not_disturb_list = PBField.initRepeat(pBUInt64Field);
            this.hide_friend_list = PBField.initRepeat(pBUInt64Field);
        }
    };
    public final PBRepeatField<Long> game_box_appids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
