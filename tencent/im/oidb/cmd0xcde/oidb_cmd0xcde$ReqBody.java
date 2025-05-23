package tencent.im.oidb.cmd0xcde;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xcde$ReqBody extends MessageMicro<oidb_cmd0xcde$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"get_encrypt_key_req", "get_decrypt_key_req"}, new Object[]{null, null}, oidb_cmd0xcde$ReqBody.class);
    public oidb_cmd0xcde$GetEncrptkeyReq get_encrypt_key_req = new oidb_cmd0xcde$GetEncrptkeyReq();
    public oidb_cmd0xcde$GetDecryptKeyReq get_decrypt_key_req = new oidb_cmd0xcde$GetDecryptKeyReq();
}
