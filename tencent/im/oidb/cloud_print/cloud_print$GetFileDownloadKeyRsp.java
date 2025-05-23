package tencent.im.oidb.cloud_print;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cloud_print$GetFileDownloadKeyRsp extends MessageMicro<cloud_print$GetFileDownloadKeyRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ret_code", "ret_msg", "key_info"}, new Object[]{0, "", null}, cloud_print$GetFileDownloadKeyRsp.class);
    public final PBInt32Field ret_code = PBField.initInt32(0);
    public final PBStringField ret_msg = PBField.initString("");
    public cloud_print$FileDownloadKeyInfo key_info = new cloud_print$FileDownloadKeyInfo();
}
