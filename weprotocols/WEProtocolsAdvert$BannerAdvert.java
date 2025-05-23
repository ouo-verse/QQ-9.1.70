package weprotocols;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qwallet.transaction.impl.TransactionActivity;

/* loaded from: classes30.dex */
public final class WEProtocolsAdvert$BannerAdvert extends MessageMicro<WEProtocolsAdvert$BannerAdvert> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"id", TransactionActivity.PREF_NAME_TRANSFER, "meta_data", "has_banner"}, new Object[]{"", "", ByteStringMicro.EMPTY, Boolean.FALSE}, WEProtocolsAdvert$BannerAdvert.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f445552id = PBField.initString("");
    public final PBStringField transfer = PBField.initString("");
    public final PBBytesField meta_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBoolField has_banner = PBField.initBool(false);
}
