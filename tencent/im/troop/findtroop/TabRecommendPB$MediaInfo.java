package tencent.im.troop.findtroop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class TabRecommendPB$MediaInfo extends MessageMicro<TabRecommendPB$MediaInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42}, new String[]{"type", "pic_url", "text", "has_pic", "report_data"}, new Object[]{0, "", "", Boolean.FALSE, ""}, TabRecommendPB$MediaInfo.class);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBStringField pic_url = PBField.initString("");
    public final PBStringField text = PBField.initString("");
    public final PBBoolField has_pic = PBField.initBool(false);
    public final PBStringField report_data = PBField.initString("");
}
