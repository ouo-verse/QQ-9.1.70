package tencent.im.oidb.cmd0x66b;

import appoint.define.appoint_define$PublisherInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x66b$RspBody extends MessageMicro<Oidb_0x66b$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_rspbody_5eb;
    public final PBBytesField bytes_rspbody_gift;
    public final PBRepeatMessageField<appoint_define$PublisherInfo> rpt_msg_vistor_info;
    public final PBRepeatMessageField<Oidb_0x66b$RspConfigItem> stConfigList;
    public Oidb_0x66b$RspLikeInfo stLikeInfo;
    public Oidb_0x66b$RspPansocialInfo stPansocialInfo;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{480802, 481602, 482402, 483202, 484002, 484802}, new String[]{"bytes_rspbody_5eb", "stLikeInfo", "stPansocialInfo", "bytes_rspbody_gift", "stConfigList", "rpt_msg_vistor_info"}, new Object[]{byteStringMicro, null, null, byteStringMicro, null, null}, Oidb_0x66b$RspBody.class);
    }

    public Oidb_0x66b$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_rspbody_5eb = PBField.initBytes(byteStringMicro);
        this.stLikeInfo = new Oidb_0x66b$RspLikeInfo();
        this.stPansocialInfo = new Oidb_0x66b$RspPansocialInfo();
        this.bytes_rspbody_gift = PBField.initBytes(byteStringMicro);
        this.stConfigList = PBField.initRepeatMessage(Oidb_0x66b$RspConfigItem.class);
        this.rpt_msg_vistor_info = PBField.initRepeatMessage(appoint_define$PublisherInfo.class);
    }
}
