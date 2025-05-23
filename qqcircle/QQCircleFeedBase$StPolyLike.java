package qqcircle;

import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StPolyLike extends MessageMicro<QQCircleFeedBase$StPolyLike> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, 58, 64, 72, 80, 90, 98, 106, 114, 122, 130}, new String[]{"polyLikeID", "polyName", "polySource", "polyIconUrl", "count", "polyUnderPicUrl", "polyPreviewSource", "articleType", "price", "clicked", MessageForQCircleFeed.MSG_QCIRCLE_FEED_LEY_BUSI_DATA, "fullScreenURL", "fullScreenURLAND", "polyTxtColor", "polyUnderColor", "dynamicPicURL"}, new Object[]{"", "", "", "", 0, "", "", 0, 0, Boolean.FALSE, ByteStringMicro.EMPTY, "", "", "", "", ""}, QQCircleFeedBase$StPolyLike.class);
    public final PBStringField polyLikeID = PBField.initString("");
    public final PBStringField polyName = PBField.initString("");
    public final PBStringField polySource = PBField.initString("");
    public final PBStringField polyIconUrl = PBField.initString("");
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBStringField polyUnderPicUrl = PBField.initString("");
    public final PBStringField polyPreviewSource = PBField.initString("");
    public final PBEnumField articleType = PBField.initEnum(0);
    public final PBUInt32Field price = PBField.initUInt32(0);
    public final PBBoolField clicked = PBField.initBool(false);
    public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField fullScreenURL = PBField.initString("");
    public final PBStringField fullScreenURLAND = PBField.initString("");
    public final PBStringField polyTxtColor = PBField.initString("");
    public final PBStringField polyUnderColor = PBField.initString("");
    public final PBStringField dynamicPicURL = PBField.initString("");
}
