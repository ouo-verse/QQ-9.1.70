package unify.search;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class UnifySearchUniteMore$Label extends MessageMicro<UnifySearchUniteMore$Label> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 48}, new String[]{"attr", "edging_color", "enum_type", "name", "text_color", "type"}, new Object[]{0, null, 0, "", null, 0}, UnifySearchUniteMore$Label.class);
    public final PBInt32Field attr = PBField.initInt32(0);
    public UnifySearchUniteMore$Color edging_color = new UnifySearchUniteMore$Color();
    public final PBInt32Field enum_type = PBField.initInt32(0);
    public final PBStringField name = PBField.initString("");
    public UnifySearchUniteMore$Color text_color = new UnifySearchUniteMore$Color();
    public final PBInt32Field type = PBField.initInt32(0);
}
