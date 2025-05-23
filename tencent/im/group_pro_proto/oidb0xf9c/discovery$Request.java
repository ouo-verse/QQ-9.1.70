package tencent.im.group_pro_proto.oidb0xf9c;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class discovery$Request extends MessageMicro<discovery$Request> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{PictureConst.KEY_CATEGORY_ID}, new Object[]{0}, discovery$Request.class);
    public final PBUInt32Field category_id = PBField.initUInt32(0);
}
