package qzone;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qzoneHolidayshare$GetShareCardRsp extends MessageMicro<qzoneHolidayshare$GetShareCardRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"sign_ark"}, new Object[]{ByteStringMicro.EMPTY}, qzoneHolidayshare$GetShareCardRsp.class);
    public final PBBytesField sign_ark = PBField.initBytes(ByteStringMicro.EMPTY);
}
