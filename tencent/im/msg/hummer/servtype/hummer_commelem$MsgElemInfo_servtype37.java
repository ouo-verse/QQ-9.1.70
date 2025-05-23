package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hummer_commelem$MsgElemInfo_servtype37 extends MessageMicro<hummer_commelem$MsgElemInfo_servtype37> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_packid;
    public final PBBytesField bytes_resultid;
    public final PBBytesField bytes_stickerid;
    public final PBBytesField bytes_surpriseid;
    public final PBBytesField bytes_text;
    public final PBUInt32Field uint32_qsid;
    public final PBEnumField uint32_randomtype;
    public final PBEnumField uint32_sourcetype;
    public final PBEnumField uint32_stickertype;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 50, 58, 66, 72}, new String[]{"bytes_packid", "bytes_stickerid", "uint32_qsid", "uint32_sourcetype", "uint32_stickertype", "bytes_resultid", "bytes_text", "bytes_surpriseid", "uint32_randomtype"}, new Object[]{byteStringMicro, byteStringMicro, 0, 1, 1, byteStringMicro, byteStringMicro, byteStringMicro, 1}, hummer_commelem$MsgElemInfo_servtype37.class);
    }

    public hummer_commelem$MsgElemInfo_servtype37() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_packid = PBField.initBytes(byteStringMicro);
        this.bytes_stickerid = PBField.initBytes(byteStringMicro);
        this.uint32_qsid = PBField.initUInt32(0);
        this.uint32_sourcetype = PBField.initEnum(1);
        this.uint32_stickertype = PBField.initEnum(1);
        this.bytes_resultid = PBField.initBytes(byteStringMicro);
        this.bytes_text = PBField.initBytes(byteStringMicro);
        this.bytes_surpriseid = PBField.initBytes(byteStringMicro);
        this.uint32_randomtype = PBField.initEnum(1);
    }
}
