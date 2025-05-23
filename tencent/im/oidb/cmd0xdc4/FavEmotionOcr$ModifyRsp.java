package tencent.im.oidb.cmd0xdc4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleLpReportDc05507;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class FavEmotionOcr$ModifyRsp extends MessageMicro<FavEmotionOcr$ModifyRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{QCircleLpReportDc05507.KEY_PIC_INFO, "int32_result", "string_fail_msg"}, new Object[]{null, 0, ""}, FavEmotionOcr$ModifyRsp.class);
    public FavEmotionOcr$PicInfo pic_info = new FavEmotionOcr$PicInfo();
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBStringField string_fail_msg = PBField.initString("");
}
