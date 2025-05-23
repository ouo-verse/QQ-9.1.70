package tencent.im.oidb.cmd0xfc2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xfc2$ApplyDownloadRsp extends MessageMicro<oidb_0xfc2$ApplyDownloadRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"msg_download_info", "msg_file_info", "msg_chacha20_param", "uint32_use_encrypt"}, new Object[]{null, null, null, 0}, oidb_0xfc2$ApplyDownloadRsp.class);
    public oidb_0xfc2$DownloadInfo msg_download_info = new oidb_0xfc2$DownloadInfo();
    public oidb_0xfc2$FileInfo msg_file_info = new oidb_0xfc2$FileInfo();
    public oidb_0xfc2$ChaCha20EncryptParam msg_chacha20_param = new MessageMicro<oidb_0xfc2$ChaCha20EncryptParam>() { // from class: tencent.im.oidb.cmd0xfc2.oidb_0xfc2$ChaCha20EncryptParam
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"str32_hexkey", "str8_hexnonce"}, new Object[]{"", ""}, oidb_0xfc2$ChaCha20EncryptParam.class);
        public final PBStringField str32_hexkey = PBField.initString("");
        public final PBStringField str8_hexnonce = PBField.initString("");
    };
    public final PBUInt32Field uint32_use_encrypt = PBField.initUInt32(0);
}
