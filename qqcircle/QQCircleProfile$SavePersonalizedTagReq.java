package qqcircle;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QQCircleProfile$SavePersonalizedTagReq extends MessageMicro<QQCircleProfile$SavePersonalizedTagReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "scene"}, new Object[]{null, 0}, QQCircleProfile$SavePersonalizedTagReq.class);
    public final PBRepeatMessageField<QQCircleProfile$ContentFirstClass> tags = PBField.initRepeatMessage(QQCircleProfile$ContentFirstClass.class);
    public final PBEnumField scene = PBField.initEnum(0);
}
