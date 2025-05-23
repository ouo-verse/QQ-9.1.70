package tencent.im.nearfield_friend;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class nearfield_friend$GPS extends MessageMicro<nearfield_friend$GPS> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{QCircleSchemeAttr.Polymerize.LAT, "lng", "type"}, new Object[]{0, 0, 0}, nearfield_friend$GPS.class);
    public final PBInt32Field lat = PBField.initInt32(0);
    public final PBInt32Field lng = PBField.initInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
}
