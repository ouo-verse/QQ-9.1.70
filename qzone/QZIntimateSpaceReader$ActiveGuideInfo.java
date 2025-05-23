package qzone;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceReader$ActiveGuideInfo extends MessageMicro<QZIntimateSpaceReader$ActiveGuideInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"guide_title", "theme_color", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "left_btn_title", "right_btn_btn_title", "relation_icons"}, new Object[]{"", "", "", "", "", ""}, QZIntimateSpaceReader$ActiveGuideInfo.class);
    public final PBStringField left_btn_title;
    public final PBRepeatField<String> relation_icons;
    public final PBStringField right_btn_btn_title;
    public final PBRepeatField<String> tags;
    public final PBStringField guide_title = PBField.initString("");
    public final PBStringField theme_color = PBField.initString("");

    public QZIntimateSpaceReader$ActiveGuideInfo() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.tags = PBField.initRepeat(pBStringField);
        this.left_btn_title = PBField.initString("");
        this.right_btn_btn_title = PBField.initString("");
        this.relation_icons = PBField.initRepeat(pBStringField);
    }
}
