package tencent.im.oidb.cmd0xdc4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleLpReportDc05507;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class FavEmotionOcr$OcrInfo extends MessageMicro<FavEmotionOcr$OcrInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{QCircleLpReportDc05507.KEY_PIC_INFO, "string_pic_ocr", "string_self_desc", "string_bytes_other"}, new Object[]{null, "", "", ""}, FavEmotionOcr$OcrInfo.class);
    public FavEmotionOcr$PicInfo pic_info = new FavEmotionOcr$PicInfo();
    public final PBStringField string_pic_ocr = PBField.initString("");
    public final PBStringField string_self_desc = PBField.initString("");
    public final PBStringField string_bytes_other = PBField.initString("");
}
