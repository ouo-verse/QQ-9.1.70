package tencent.im.cs.cmd0xe07;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class cmd0xe07$Polygon extends MessageMicro<cmd0xe07$Polygon> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"coordinates"}, new Object[]{null}, cmd0xe07$Polygon.class);
    public final PBRepeatMessageField<cmd0xe07$Coordinate> coordinates = PBField.initRepeatMessage(cmd0xe07$Coordinate.class);
}
