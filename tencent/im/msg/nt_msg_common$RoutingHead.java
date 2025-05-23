package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nt_msg_common$RoutingHead extends MessageMicro<nt_msg_common$RoutingHead> {
    static final MessageMicro.FieldMap __fieldMap__;
    public nt_msg_common$C2c c2c;
    public final PBUInt32Field from_appid;
    public final PBUInt32Field from_instid;
    public final PBBytesField from_uid;
    public final PBUInt64Field from_uin = PBField.initUInt64(0);
    public nt_msg_common$Group group;
    public final PBBytesField to_uid;
    public final PBUInt64Field to_uin;

    static {
        String[] strArr = {ShortVideoConstants.FROM_UIN, "from_uid", "from_appid", "from_instid", "to_uin", "to_uid", "c2c", VipFunCallConstants.KEY_GROUP};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 50, 58, 66}, strArr, new Object[]{0L, byteStringMicro, 0, 0, 0L, byteStringMicro, null, null}, nt_msg_common$RoutingHead.class);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [tencent.im.msg.nt_msg_common$C2c] */
    public nt_msg_common$RoutingHead() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.from_uid = PBField.initBytes(byteStringMicro);
        this.from_appid = PBField.initUInt32(0);
        this.from_instid = PBField.initUInt32(0);
        this.to_uin = PBField.initUInt64(0L);
        this.to_uid = PBField.initBytes(byteStringMicro);
        this.c2c = new MessageMicro<nt_msg_common$C2c>() { // from class: tencent.im.msg.nt_msg_common$C2c
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], nt_msg_common$C2c.class);
        };
        this.group = new nt_msg_common$Group();
    }
}
