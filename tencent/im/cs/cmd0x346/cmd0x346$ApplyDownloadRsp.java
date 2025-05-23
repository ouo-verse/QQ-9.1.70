package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x346$ApplyDownloadRsp extends MessageMicro<cmd0x346$ApplyDownloadRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 162, 242, 322, 402}, new String[]{"int32_ret_code", "str_ret_msg", "msg_download_info", "msg_file_info", "bytes_file_sha"}, new Object[]{0, "", null, null, ByteStringMicro.EMPTY}, cmd0x346$ApplyDownloadRsp.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_ret_msg = PBField.initString("");
    public cmd0x346$DownloadInfo msg_download_info = new cmd0x346$DownloadInfo();
    public cmd0x346$FileInfo msg_file_info = new cmd0x346$FileInfo();
    public final PBBytesField bytes_file_sha = PBField.initBytes(ByteStringMicro.EMPTY);
}
