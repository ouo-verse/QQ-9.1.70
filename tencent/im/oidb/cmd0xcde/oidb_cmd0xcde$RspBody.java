package tencent.im.oidb.cmd0xcde;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xcde$RspBody extends MessageMicro<oidb_cmd0xcde$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"get_encrypt_key_rsp", "get_decrypt_key_rsp"}, new Object[]{null, null}, oidb_cmd0xcde$RspBody.class);
    public oidb_cmd0xcde$GetEncryptKeyRsp get_encrypt_key_rsp = new oidb_cmd0xcde$GetEncryptKeyRsp();
    public oidb_cmd0xcde$GetDecryptKeyRsp get_decrypt_key_rsp = new oidb_cmd0xcde$GetDecryptKeyRsp();
}
