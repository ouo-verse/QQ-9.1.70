package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleDitto$StCircleDittoDataNew extends MessageMicro<QQCircleDitto$StCircleDittoDataNew> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"itemContainter", "singlePicBanner", "dividingLine", "multiItemContainter", "flipCard", "picTextBanner", "feedItem"}, new Object[]{null, null, null, null, null, null, null}, QQCircleDitto$StCircleDittoDataNew.class);
    public QQCircleDitto$StItemContainer itemContainter = new QQCircleDitto$StItemContainer();
    public QQCircleDitto$StSinglePicBanner singlePicBanner = new QQCircleDitto$StSinglePicBanner();
    public QQCircleDitto$StDividingLine dividingLine = new QQCircleDitto$StDividingLine();
    public final PBRepeatMessageField<QQCircleDitto$StItemContainer> multiItemContainter = PBField.initRepeatMessage(QQCircleDitto$StItemContainer.class);
    public QQCircleDitto$StFlipCard flipCard = new MessageMicro<QQCircleDitto$StFlipCard>() { // from class: qqcircle.QQCircleDitto$StFlipCard
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"cardName", "opMask", IndividuationUrlHelper.UrlId.CARD_DETAIL}, new Object[]{"", 0, null}, QQCircleDitto$StFlipCard.class);
        public final PBStringField cardName = PBField.initString("");
        public final PBRepeatField<Integer> opMask = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
        public QQCircleDitto$StCardDetail cardDetail = new MessageMicro<QQCircleDitto$StCardDetail>() { // from class: qqcircle.QQCircleDitto$StCardDetail
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"frontCardDP", "backCardDP"}, new Object[]{null, null}, QQCircleDitto$StCardDetail.class);
            public QQCircleDitto$StFrontCardDP frontCardDP = new MessageMicro<QQCircleDitto$StFrontCardDP>() { // from class: qqcircle.QQCircleDitto$StFrontCardDP
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"recomUser", "matchReson", "recomCommReson", "recomReason", "buttons"}, new Object[]{null, "", "", "", null}, QQCircleDitto$StFrontCardDP.class);
                public final PBRepeatMessageField<QQCircleDitto$StButton> buttons;
                public final PBRepeatField<String> matchReson;
                public final PBStringField recomCommReson;
                public final PBRepeatField<String> recomReason;
                public FeedCloudMeta$StUser recomUser = new FeedCloudMeta$StUser();

                {
                    PBStringField pBStringField = PBStringField.__repeatHelper__;
                    this.matchReson = PBField.initRepeat(pBStringField);
                    this.recomCommReson = PBField.initString("");
                    this.recomReason = PBField.initRepeat(pBStringField);
                    this.buttons = PBField.initRepeatMessage(QQCircleDitto$StButton.class);
                }
            };
            public QQCircleDitto$StBackCardDP backCardDP = new MessageMicro<QQCircleDitto$StBackCardDP>() { // from class: qqcircle.QQCircleDitto$StBackCardDP
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"recomFeed", "buttons"}, new Object[]{null, null}, QQCircleDitto$StBackCardDP.class);
                public FeedCloudMeta$StFeed recomFeed = new FeedCloudMeta$StFeed();
                public final PBRepeatMessageField<QQCircleDitto$StButton> buttons = PBField.initRepeatMessage(QQCircleDitto$StButton.class);
            };
        };
    };
    public QQCircleDitto$StPicTextBanner picTextBanner = new QQCircleDitto$StPicTextBanner();
    public QQCircleDitto$StFeedItemInfo feedItem = new QQCircleDitto$StFeedItemInfo();
}
