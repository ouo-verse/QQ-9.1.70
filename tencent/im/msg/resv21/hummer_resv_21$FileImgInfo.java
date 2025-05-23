package tencent.im.msg.resv21;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hummer_resv_21$FileImgInfo extends MessageMicro<hummer_resv_21$FileImgInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_file_width", "uint32_file_height"}, new Object[]{0, 0}, hummer_resv_21$FileImgInfo.class);
    public final PBUInt32Field uint32_file_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_height = PBField.initUInt32(0);
}
