package tencent.im.oidb.cmd0xb73;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xb73$RspBody extends MessageMicro<oidb_0xb73$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"bytes_cookie", "uint32_next_req_interval", "msg_like_animation_config"}, new Object[]{ByteStringMicro.EMPTY, 0, null}, oidb_0xb73$RspBody.class);
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_next_req_interval = PBField.initUInt32(0);
    public oidb_0xb73$LikeAnimationConfig msg_like_animation_config = new MessageMicro<oidb_0xb73$LikeAnimationConfig>() { // from class: tencent.im.oidb.cmd0xb73.oidb_0xb73$LikeAnimationConfig
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_icon_config_list"}, new Object[]{null}, oidb_0xb73$LikeAnimationConfig.class);
        public final PBRepeatMessageField<oidb_0xb73$LikeAnimationIconConfig> rpt_msg_icon_config_list = PBField.initRepeatMessage(oidb_0xb73$LikeAnimationIconConfig.class);
    };
}
