package tencent.im.cs.cmd0xe07;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xe07$Coordinate extends MessageMicro<cmd0xe07$Coordinate> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"X", "Y"}, new Object[]{0, 0}, cmd0xe07$Coordinate.class);
    public final PBInt32Field X = PBField.initInt32(0);
    public final PBInt32Field Y = PBField.initInt32(0);
}
