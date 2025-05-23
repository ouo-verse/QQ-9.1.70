package tencent.im.oidb.cmd0xdc4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleLpReportDc05507;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class FavEmotionOcr$ModifyReq extends MessageMicro<FavEmotionOcr$ModifyReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{QCircleLpReportDc05507.KEY_PIC_INFO, "string_self_desc_new"}, new Object[]{null, ""}, FavEmotionOcr$ModifyReq.class);
    public FavEmotionOcr$PicInfo pic_info = new FavEmotionOcr$PicInfo();
    public final PBStringField string_self_desc_new = PBField.initString("");
}
