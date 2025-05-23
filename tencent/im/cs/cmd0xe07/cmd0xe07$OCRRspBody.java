package tencent.im.cs.cmd0xe07;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xe07$OCRRspBody extends MessageMicro<cmd0xe07$OCRRspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 810, 818, BusinessInfoCheckUpdateItem.UIAPPID_XINGQU_BULUO, 888, 896}, new String[]{"textDetections", IjkMediaMeta.IJKM_KEY_LANGUAGE, QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "ocrLanguageList", "dstTranslateLanguageList", "languageList", "afterCompressWeight", "afterCompressHeight"}, new Object[]{null, "", "", "", "", null, 0, 0}, cmd0xe07$OCRRspBody.class);
    public final PBUInt32Field afterCompressHeight;
    public final PBUInt32Field afterCompressWeight;
    public final PBRepeatField<String> dstTranslateLanguageList;
    public final PBRepeatMessageField<cmd0xe07$Language> languageList;
    public final PBRepeatField<String> ocrLanguageList;
    public final PBRepeatMessageField<cmd0xe07$TextDetection> textDetections = PBField.initRepeatMessage(cmd0xe07$TextDetection.class);
    public final PBStringField language = PBField.initString("");
    public final PBStringField requestId = PBField.initString("");

    public cmd0xe07$OCRRspBody() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.ocrLanguageList = PBField.initRepeat(pBStringField);
        this.dstTranslateLanguageList = PBField.initRepeat(pBStringField);
        this.languageList = PBField.initRepeatMessage(cmd0xe07$Language.class);
        this.afterCompressWeight = PBField.initUInt32(0);
        this.afterCompressHeight = PBField.initUInt32(0);
    }
}
