package qshadow;

import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ShadowStickerSearch$MaterialInfo extends MessageMicro<ShadowStickerSearch$MaterialInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 50, 58, 66, 74, 82, 90}, new String[]{"id", "metaSdkInfo", "thumbURL", "thumbWidth", "thumbHeight", "packageURL", "checksumMd5", "additionalPackage", "additionalFields", CommonConstant.KEY_DISPLAY_NAME, MessageForQQStory.KEY_AUTHOR_NAME}, new Object[]{"", null, "", 0, 0, "", "", null, null, "", ""}, ShadowStickerSearch$MaterialInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f429489id = PBField.initString("");
    public ShadowStickerSearch$MetaSdkInfo metaSdkInfo = new ShadowStickerSearch$MetaSdkInfo();
    public final PBStringField thumbURL = PBField.initString("");
    public final PBUInt32Field thumbWidth = PBField.initUInt32(0);
    public final PBUInt32Field thumbHeight = PBField.initUInt32(0);
    public final PBStringField packageURL = PBField.initString("");
    public final PBStringField checksumMd5 = PBField.initString("");
    public ShadowStickerSearch$MetaAdditionalPackage additionalPackage = new ShadowStickerSearch$MetaAdditionalPackage();
    public final PBRepeatMessageField<ShadowStickerSearch$AdditionalEntry> additionalFields = PBField.initRepeatMessage(ShadowStickerSearch$AdditionalEntry.class);
    public final PBStringField displayName = PBField.initString("");
    public final PBStringField authorName = PBField.initString("");
}
