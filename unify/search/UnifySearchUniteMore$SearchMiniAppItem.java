package unify.search;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class UnifySearchUniteMore$SearchMiniAppItem extends MessageMicro<UnifySearchUniteMore$SearchMiniAppItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 64, 72}, new String[]{"cover", "name", "desc", "labels", "jump_url", "classification", "appid", "show_mask", "miniapp_type"}, new Object[]{"", "", "", null, "", "", "", 0, 0}, UnifySearchUniteMore$SearchMiniAppItem.class);
    public final PBStringField cover = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBRepeatMessageField<UnifySearchUniteMore$Label> labels = PBField.initRepeatMessage(UnifySearchUniteMore$Label.class);
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField classification = PBField.initString("");
    public final PBStringField appid = PBField.initString("");
    public final PBInt32Field show_mask = PBField.initInt32(0);
    public final PBInt32Field miniapp_type = PBField.initInt32(0);
}
