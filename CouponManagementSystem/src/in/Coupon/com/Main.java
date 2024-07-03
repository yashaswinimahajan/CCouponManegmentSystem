package in.Coupon.com;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class Main {
	        public static void main(String[] args) {
	        DelayQueue<DiscountCoupon> queue = new DelayQueue<>();

	        queue.add(new DiscountCoupon("SAVE10", 5, TimeUnit.SECONDS));
	        queue.add(new DiscountCoupon("OFF20", 10, TimeUnit.SECONDS));
	        queue.add(new DiscountCoupon("DISCOUNT30", 15, TimeUnit.SECONDS));

	        CouponExpiryProcessor processor = new CouponExpiryProcessor(queue);
	        Thread processorThread = new Thread(processor);
	        processorThread.start();
	        }
}
