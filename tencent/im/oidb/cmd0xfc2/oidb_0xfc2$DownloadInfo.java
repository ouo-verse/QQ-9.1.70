package tencent.im.oidb.cmd0xfc2;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xfc2$DownloadInfo extends MessageMicro<oidb_0xfc2$DownloadInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"bytes_download_key", "msg_out_addr", "msg_inner_addr", "msg_out_addr_ipv6", "str_download_domain", "str_download_url", "str_cookie"}, new Object[]{ByteStringMicro.EMPTY, null, null, null, "", "", ""}, oidb_0xfc2$DownloadInfo.class);
    public final PBBytesField bytes_download_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0xfc2$Addr> msg_out_addr = PBField.initRepeatMessage(oidb_0xfc2$Addr.class);
    public final PBRepeatMessageField<oidb_0xfc2$Addr> msg_inner_addr = PBField.initRepeatMessage(oidb_0xfc2$Addr.class);
    public final PBRepeatMessageField<oidb_0xfc2$Addr> msg_out_addr_ipv6 = PBField.initRepeatMessage(oidb_0xfc2$Addr.class);
    public final PBStringField str_download_domain = PBField.initString("");
    public final PBStringField str_download_url = PBField.initString("");
    public final PBStringField str_cookie = PBField.initString("");
}
