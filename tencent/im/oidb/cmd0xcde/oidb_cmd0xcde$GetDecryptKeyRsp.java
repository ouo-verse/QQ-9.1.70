package tencent.im.oidb.cmd0xcde;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xcde$GetDecryptKeyRsp extends MessageMicro<oidb_cmd0xcde$GetDecryptKeyRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"dncrypt_key"}, new Object[]{ByteStringMicro.EMPTY}, oidb_cmd0xcde$GetDecryptKeyRsp.class);
    public final PBBytesField dncrypt_key = PBField.initBytes(ByteStringMicro.EMPTY);
}
