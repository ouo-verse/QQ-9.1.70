package tencent.im.cs.cmd0x3fe;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x3fe$qun_video_identity_score extends MessageMicro<cmd0x3fe$qun_video_identity_score> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56}, new String[]{"uint32_identity_score", "uint32_time", "uint32_send_flower_num", "uint32_recv_flower_num", "uint32_send_gift_num", "uint32_recv_gift_num", "uint32_online_time"}, new Object[]{0, 0, 0, 0, 0, 0, 0}, cmd0x3fe$qun_video_identity_score.class);
    public final PBUInt32Field uint32_identity_score = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_send_flower_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_recv_flower_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_send_gift_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_recv_gift_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_online_time = PBField.initUInt32(0);
}
