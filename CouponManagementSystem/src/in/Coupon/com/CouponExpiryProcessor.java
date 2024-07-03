package in.Coupon.com;
import java.util.concurrent.DelayQueue;

	public class CouponExpiryProcessor implements Runnable {
	    private DelayQueue<DiscountCoupon> queue;

	    public CouponExpiryProcessor(DelayQueue<DiscountCoupon> queue) {
	        this.queue = queue;
	    }

	    @Override
	    public void run() {
	        try {
	            while (true) {
	                DiscountCoupon coupon = queue.take();
	                System.out.println("Coupon expired: " + coupon.getCouponCode());
	            }
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	    }
	}









