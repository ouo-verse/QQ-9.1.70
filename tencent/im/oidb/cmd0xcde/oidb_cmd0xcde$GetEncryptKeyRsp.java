package tencent.im.oidb.cmd0xcde;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xcde$GetEncryptKeyRsp extends MessageMicro<oidb_cmd0xcde$GetEncryptKeyRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField encrypt_key;
    public final PBBytesField file_meta;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"encrypt_key", "file_meta"}, new Object[]{byteStringMicro, byteStringMicro}, oidb_cmd0xcde$GetEncryptKeyRsp.class);
    }

    public oidb_cmd0xcde$GetEncryptKeyRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.encrypt_key = PBField.initBytes(byteStringMicro);
        this.file_meta = PBField.initBytes(byteStringMicro);
    }
}
